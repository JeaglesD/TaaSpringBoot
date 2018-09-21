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
import taa.springboot.service.PlaceDao;

@RestController
@RequestMapping("/places")
public class PlaceController {
	@Autowired
	private PlaceDao placeDao;
	
	@PostMapping("/create")
	public @ResponseBody ResponseEntity<String> create(@RequestBody Place place){
		try{
			placeDao.save(place);
		}catch(Exception e) {
			return new ResponseEntity<String>("POST place Response", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("POST place Response", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable Long id){
		try {
			placeDao.delete(placeDao.findById(id).get());
		} catch (Exception ex) {
			return new ResponseEntity<String>("DELETE place Response", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("DELETE place Response", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Place> getById(@PathVariable Long id){
		return new ResponseEntity<Place>(placeDao.findById(id).get(), HttpStatus.OK);
	}
	
	@GetMapping("/postCode/{postCode}")
	public @ResponseBody ResponseEntity<List<Place>> getByPostCode(@PathVariable String postCode){
		return new ResponseEntity<List<Place>>(placeDao.findByPostCode(Integer.parseInt(postCode)), HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public @ResponseBody ResponseEntity<List<Place>> getByName(@PathVariable String name){
		return new ResponseEntity<List<Place>>(placeDao.findByName(name), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public @ResponseBody ResponseEntity<String> update(@RequestBody Place place) {
		try {		
			placeDao.save(place);
		}catch (Exception ex) {
			return new ResponseEntity<String>("PUT place Response",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("PUT place Response",HttpStatus.OK);
	}

}
