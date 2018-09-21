package taa.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import taa.springboot.domain.User;
import taa.springboot.service.UserDao;

@RestController
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping("/users/create")
	public @ResponseBody ResponseEntity<String> create(@RequestBody User user){
		try{
			userDao.save(user);
		}catch(Exception e) {
			return new ResponseEntity<String>("POST Response", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("POST Response", HttpStatus.OK);
	}
	
	@DeleteMapping("/users/delete/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable String id){
		try {
			userDao.delete(userDao.findById(Long.parseLong(id)).get());
		} catch (Exception ex) {
			return new ResponseEntity<String>("DELETE Response", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public @ResponseBody ResponseEntity<User> getById(@PathVariable String id){
		return new ResponseEntity<User>(userDao.findById(Long.parseLong(id)).get(), HttpStatus.OK);
	}
	
	@GetMapping("/users/pseudo/{pseudo}")
	public @ResponseBody ResponseEntity<User> getByPseudo(@PathVariable String pseudo){
		return new ResponseEntity<User>(userDao.findByPseudo(pseudo), HttpStatus.OK);
	}
	
	@PutMapping("/users/update")
	public @ResponseBody ResponseEntity<String> update(@RequestBody User user) {
		try {		
			userDao.save(user);
		}catch (Exception ex) {
			return new ResponseEntity<String>("PUT Response",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("PUT Response",HttpStatus.OK);
	}
	
}
