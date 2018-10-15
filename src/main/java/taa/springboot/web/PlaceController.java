package taa.springboot.web;

import java.util.ArrayList;
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
import taa.springboot.dto.PlaceDto;
import taa.springboot.service.PlaceDao;

@RestController
@RequestMapping("/api/places")
public class PlaceController {
	@Autowired
	private PlaceDao placeDao;
	
	@PostMapping("/create")
	public @ResponseBody ResponseEntity<String> create(@RequestBody Place place){
		try{
			placeDao.save(place);
		}catch(Exception e) {
			return new ResponseEntity<String>("POST place not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("POST place ok", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable Long id){
		try {
			placeDao.delete(placeDao.findById(id).get());
		} catch (Exception ex) {
			return new ResponseEntity<String>("DELETE place not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("DELETE place ok", HttpStatus.OK);
	}
	
	@GetMapping("/")
	public @ResponseBody ResponseEntity<List<PlaceDto>> getAll(){
		System.out.println("ici");
		try{
			System.out.println("là");
			List<PlaceDto> placesDto = new ArrayList<PlaceDto>();
			List<Place> places = placeDao.findAll();
			for(Place place : places){
				placesDto.add(place.toPlaceDto());
			}
			return new ResponseEntity<List<PlaceDto>>(placesDto,HttpStatus.OK);
		}catch(Exception ex){
			return new ResponseEntity<List<PlaceDto>>(new ArrayList<PlaceDto>(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<PlaceDto> getById(@PathVariable Long id){
		return new ResponseEntity<PlaceDto>(placeDao.findById(id).get().toPlaceDto(), HttpStatus.OK);
	}
	

	@GetMapping("/name/{name}")
	public @ResponseBody ResponseEntity<List<PlaceDto>> getByName(@PathVariable String name){
		List<PlaceDto> placesDto = new ArrayList<PlaceDto>();
		for(Place place : placeDao.findByName(name)){
			placesDto.add(place.toPlaceDto());
		}
		return new ResponseEntity<List<PlaceDto>>(placesDto,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public @ResponseBody ResponseEntity<String> update(@RequestBody Place place) {
		try {		
			placeDao.save(place);
		}catch (Exception ex) {
			return new ResponseEntity<String>("PUT place not found",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("PUT place ok",HttpStatus.OK);
	}

}
