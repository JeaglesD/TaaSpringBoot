package taa.springboot.web;

import java.util.List;

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
import taa.springboot.service.PlaceDao;
import taa.springboot.service.UserDao;

@RestController()
@RequestMapping("/users")
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
			return new ResponseEntity<String>("POST user Response", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("POST user Response", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable Long id){
		try {
			userDao.delete(userDao.findById(id).get());
		} catch (Exception ex) {
			return new ResponseEntity<String>("DELETE user Response", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("DELETE user Response", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<User> getById(@PathVariable String id){
		return new ResponseEntity<User>(userDao.findById(Long.parseLong(id)).get(), HttpStatus.OK);
	}
	
	@GetMapping("/pseudo/{pseudo}")
	public @ResponseBody ResponseEntity<User> getByPseudo(@PathVariable String pseudo){
		return new ResponseEntity<User>(userDao.findByPseudo(pseudo), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public @ResponseBody ResponseEntity<String> update(@RequestBody User user) {
		try {		
			userDao.save(user);
		}catch (Exception ex) {
			return new ResponseEntity<String>("PUT user Response",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("PUT user Response",HttpStatus.OK);
	}
	
	@PutMapping("/{id}/addPlace")
	public @ResponseBody ResponseEntity<String> addPlace(@PathVariable Long id, @RequestBody Place place){
		
		try {
			User user = userDao.findById(id).get();
			Place aPlace = placeDao.findByNameAndCodePost(place.getName(), place.getPostCode());			
			System.out.println("aPlace" + aPlace.toString());
			// create the place in the database
			if(aPlace == null){
				place.getUsers().add(user);
				placeDao.save(place);
				user.getPlaces().add(place);
			}else{
				aPlace.getUsers().add(user);
				placeDao.save(aPlace);
				user.getPlaces().add(aPlace);
			}
			
		}catch(Exception ex){
			return new ResponseEntity<String>("PUT user Response", HttpStatus.BAD_REQUEST);
		}	
		return new ResponseEntity<String>("PUT user Response", HttpStatus.OK);
	}
}
