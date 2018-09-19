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

import taa.springboot.domain.Activity;
import taa.springboot.domain.User;
import taa.springboot.service.ActivityDao;
import taa.springboot.service.UserDao;
@RestController("/activity")
public class ActivityController {
	
	@Autowired
	private ActivityDao activityDao;
	
	@PostMapping("/create")
	public @ResponseBody ResponseEntity<String> create(@RequestBody Activity activity){
		try{
			activityDao.save(activity);
		}catch(Exception e) {
			return new ResponseEntity<String>("POST Response", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("POST Response", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable String id){
		try {
			activityDao.delete(activityDao.findById(Long.parseLong(id)).get());
		} catch (Exception ex) {
			return new ResponseEntity<String>("DELETE Response", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Activity> getById(@PathVariable String id){
		return new ResponseEntity<Activity>(activityDao.findById(Long.parseLong(id)).get(), HttpStatus.OK);
	}
	
	@GetMapping("/pseudo/{pseudo}")
	public @ResponseBody ResponseEntity<Activity> getByPseudo(@PathVariable String pseudo){
		return new ResponseEntity<Activity>(activityDao.findByPseudo(pseudo), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public @ResponseBody ResponseEntity<String> update(@RequestBody Activity activity) {
		try {		
			activityDao.save(activity);
		}catch (Exception ex) {
			return new ResponseEntity<String>("PUT Response",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("PUT Response",HttpStatus.OK);
	}
	
}
