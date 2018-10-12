package taa.springboot.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class UserController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private PlaceDao placeDao;
	
	@PostMapping("/create")
	public @ResponseBody ResponseEntity<String> create(@RequestBody User user){
		try{
			userDao.save(user);
		}catch(Exception e) {
			return new ResponseEntity<String>("POST user not found", HttpStatus.BAD_REQUEST);
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
		return new ResponseEntity<UserDto>(userDao.findByPseudo(pseudo).toUserDto(), HttpStatus.OK);
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
			userDao.save(user);
		}catch (Exception ex) {
			return new ResponseEntity<String>("PUT user not found",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("PUT user ok",HttpStatus.OK);
	}
	
	@PutMapping("/{idUser}/addPlace/{idPlace}")
	public @ResponseBody ResponseEntity<String> addPlace(@PathVariable Long idUser, @PathVariable Long idPlace){
		try {
			User user = userDao.findById(idUser).get();
			Place place = placeDao.findById(idPlace).get();			
			place.getUsers().add(user);
			placeDao.save(place);
			user.getPlaces().add(place);			
		}catch(Exception ex){
			return new ResponseEntity<String>("PUT user not found", HttpStatus.BAD_REQUEST);
		}	
		return new ResponseEntity<String>("PUT user ok", HttpStatus.OK);
	}

	@PutMapping("/{idUser}/removePlace/{idPlace}")
	public @ResponseBody ResponseEntity<String> removePlace(@PathVariable Long idUser, @PathVariable Long idPlace){
		try {
			User user = userDao.findById(idUser).get();
			Place place = placeDao.findById(idPlace).get();			
			place.getUsers().remove(user);
			placeDao.save(place);
			user.getPlaces().remove(place);			
		}catch(Exception ex){
			return new ResponseEntity<String>("PUT user not found", HttpStatus.BAD_REQUEST);
		}	
		return new ResponseEntity<String>("PUT user ok", HttpStatus.OK);
	}
}
