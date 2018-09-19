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

import taa.springboot.domain.Place;
import taa.springboot.service.PlaceDao;

@RestController
public class PlaceController {
	@Autowired
	private PlaceDao placeDao;
	
	@PostMapping("/places/create")
	public @ResponseBody ResponseEntity<String> create(@RequestBody Place place){
		try{
			placeDao.save(place);
		}catch(Exception e) {
			return new ResponseEntity<String>("POST place Response", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("POST place Response", HttpStatus.OK);
	}
	
	@DeleteMapping("/places/delete/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable String id){
		try {
			placeDao.delete(placeDao.findById(Long.parseLong(id)).get());
		} catch (Exception ex) {
			return new ResponseEntity<String>("DELETE place Response", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("DELETE place Response", HttpStatus.OK);
	}
	
	@GetMapping("/places/{id}")
	public @ResponseBody ResponseEntity<Place> getById(@PathVariable String id){
		return new ResponseEntity<Place>(placeDao.findById(Long.parseLong(id)).get(), HttpStatus.OK);
	}
	
	@GetMapping("/places/postCode/{postCode}")
	public @ResponseBody ResponseEntity<Place> getByPostCode(@PathVariable String postCode){
		return new ResponseEntity<Place>(placeDao.findByPostCode(postCode), HttpStatus.OK);
	}
	
	@GetMapping("/places/name/{name}")
	public @ResponseBody ResponseEntity<Place> getByName(@PathVariable String name){
		return new ResponseEntity<Place>(placeDao.findByPostCode(name), HttpStatus.OK);
	}
	
	@PutMapping("/places/update")
	public @ResponseBody ResponseEntity<String> update(@RequestBody Place place) {
		try {		
			placeDao.save(place);
		}catch (Exception ex) {
			return new ResponseEntity<String>("PUT place Response",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("PUT place Response",HttpStatus.OK);
	}
}
