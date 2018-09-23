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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import taa.springboot.domain.Activity;
import taa.springboot.domain.Place;
import taa.springboot.domain.Weather;
import taa.springboot.service.ActivityDao;
import taa.springboot.service.PlaceDao;
import taa.springboot.service.WeatherDao;

@RestController
@RequestMapping("/activities")
public class ActivityController {
	
	@Autowired
	private ActivityDao activityDao;
	@Autowired
	private WeatherDao weatherDao;
	@Autowired
	private PlaceDao placeDao;
	
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
	public @ResponseBody ResponseEntity<Activity> getByLabel(@PathVariable String pseudo){
		return new ResponseEntity<Activity>(activityDao.findByLabel(pseudo), HttpStatus.OK);
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
	
	@PutMapping("/{idActivity}/addWeather/{idWeather}")
	public @ResponseBody ResponseEntity<String> addWeather(@PathVariable Long idActivity, @PathVariable Long idWeather){
		try {
			Activity activity = activityDao.findById(idActivity).get();
			Weather weather = weatherDao.findById(idWeather).get();
			activity.getWeathers().add(weather);
		}catch(Exception ex) {
			return new ResponseEntity<String>("PUT place not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("PUT user Response", HttpStatus.OK);
		
	}
	
	@PutMapping("/{idActivity}/addPlace/{idPlace}")
	public @ResponseBody ResponseEntity<String> addPlace(@PathVariable Long idActivity,@PathVariable Long idPlace){
		try {
			Activity activity = activityDao.findById(idActivity).get();
			Place place = placeDao.findById(idPlace).get();
			place.getActivities().add(activity);
			placeDao.save(place);
			activity.getPlaces().add(place);
		}catch(Exception ex) {
			return new ResponseEntity<String>("PUT place not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("PUT user Response", HttpStatus.OK);
	}
	
	
	
	
}
