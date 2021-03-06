package taa.springboot.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import taa.springboot.domain.Place;
import taa.springboot.domain.User;
import taa.springboot.dto.PlaceDto;
import taa.springboot.dto.UserDto;
import taa.springboot.service.PlaceDao;
import taa.springboot.service.UserDao;

@RestController()
@RequestMapping("/api/users")
public class UserController implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private PlaceDao placeDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/create")
	public @ResponseBody ResponseEntity<String> create(@RequestBody User user){
		try{
			if(!userDao.findByPseudo(user.getPseudo()).isPresent()) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				userDao.save(user);
			}else {
				return new ResponseEntity<String>("POST user not created", HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			return new ResponseEntity<String>("POST user not created", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("POST user ok", HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable Long id){
		try {
			userDao.delete(userDao.findById(id).get());
		} catch (Exception ex) {
			return new ResponseEntity<String>("DELETE user not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("DELETE user ok", HttpStatus.OK);
	}
	
	@GetMapping("/")
	public @ResponseBody ResponseEntity<List<UserDto>> getAll(){
		try{
			List<UserDto> usersDto = new ArrayList<UserDto>();
			List<User> users = userDao.findAll();
			for(User user : users){
				usersDto.add(user.toUserDto());
			}			
			return new ResponseEntity<List<UserDto>>(usersDto, HttpStatus.OK);
		}catch(Exception ex){
			return new ResponseEntity<List<UserDto>>(new ArrayList<UserDto>(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<UserDto> getById(@PathVariable String id){
		return new ResponseEntity<UserDto>(userDao.findById(Long.parseLong(id)).get().toUserDto(), HttpStatus.OK);
	}
	
	@GetMapping("/pseudo/{pseudo}")
	public @ResponseBody ResponseEntity<UserDto> getByPseudo(@PathVariable String pseudo){
		UserDto userDto = new UserDto();
		try {
			userDto = userDao.findByPseudo(pseudo).get().toUserDto();			
		}catch(Exception e){
			return new ResponseEntity<UserDto>(userDto, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	
	@GetMapping("/pseudo/{pseudo}/password/{password}")
	public @ResponseBody ResponseEntity<UserDto> findByPseudoPassword(@PathVariable String pseudo, @PathVariable String password){
		UserDto userDto;
		try {
			userDto = userDao.findByPseudoAndPassword(pseudo, password).get().toUserDto();			
		}catch(Exception e){
			return new ResponseEntity<UserDto>(new UserDto(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/places")
	public @ResponseBody ResponseEntity<Set<PlaceDto>>getPlaces(@PathVariable String id){
		Set <Place> places = userDao.findById(Long.parseLong(id)).get().getPlaces();
		Set<PlaceDto> placesDto = new HashSet<PlaceDto>();
		for(Place place : places){
			placesDto.add(place.toPlaceDto());
		}
		return new ResponseEntity<Set<PlaceDto>>(placesDto, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public @ResponseBody ResponseEntity<String> update(@RequestBody User user) {
		try {
			if(userDao.findById(user.getIdUser()).isPresent()) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				userDao.save(user);			
			}else{
				return new ResponseEntity<String>("PUT user not found",HttpStatus.BAD_REQUEST);
			}
		}catch (Exception ex) {
			return new ResponseEntity<String>("PUT user not found",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("PUT user ok",HttpStatus.OK);
	}
	
	@PutMapping("/{idUser}/addPlace/{idPlace}")
	public @ResponseBody ResponseEntity<UserDto> addPlace(@PathVariable Long idUser, @PathVariable Long idPlace){
		User user;
		try {
			user = userDao.findById(idUser).get();
			Place place = placeDao.findById(idPlace).get();		
			place.getUsers().add(user);
			placeDao.save(place);
			user.getPlaces().add(place);			
		}catch(Exception ex){
			return new ResponseEntity<UserDto>(new UserDto(), HttpStatus.BAD_REQUEST);
		}	
		return new ResponseEntity<UserDto>(user.toUserDto(), HttpStatus.OK);
	}

	@PutMapping("/{idUser}/removePlace/{idPlace}")
	public @ResponseBody ResponseEntity<UserDto> removePlace(@PathVariable Long idUser, @PathVariable Long idPlace){
		User user;
		try {
			user = userDao.findById(idUser).get();
			Place place = placeDao.findById(idPlace).get();			
			place.getUsers().remove(user);
			placeDao.save(place);
			user.getPlaces().remove(place);			
		}catch(Exception ex){
			return new ResponseEntity<UserDto>(new UserDto(), HttpStatus.BAD_REQUEST);
		}	
		return new ResponseEntity<UserDto>(user.toUserDto(), HttpStatus.OK);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(userDao.findByPseudo(username).isPresent()) {
			User user = userDao.findByPseudo(username).get();
			return user;
		}else {
			System.out.println("Exception");
			throw new UsernameNotFoundException(username);
		}
	}
}


