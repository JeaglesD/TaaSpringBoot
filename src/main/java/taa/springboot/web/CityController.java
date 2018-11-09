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

import taa.springboot.domain.City;
import taa.springboot.domain.Place;
import taa.springboot.domain.User;
import taa.springboot.dto.CityDto;
import taa.springboot.dto.PlaceDto;
import taa.springboot.service.CityDao;
import taa.springboot.service.PlaceDao;

@RestController
@RequestMapping("/api/cities")
public class CityController {
	
	@Autowired
	private CityDao cityDao;
	@Autowired
	private PlaceDao placeDao;
	
	@PostMapping("/create")
	public @ResponseBody ResponseEntity<String> create(@RequestBody City city){
		try{
			cityDao.save(city);
		}catch(Exception e) {
			return new ResponseEntity<String>("POST city not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("POST city ok", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable Long id){
		try {
			cityDao.delete(cityDao.findById(id).get());
		} catch (Exception ex) {
			return new ResponseEntity<String>("DELETE city not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("DELETE city ok", HttpStatus.OK);
	}
	
	@GetMapping("/")
	public @ResponseBody ResponseEntity<List<CityDto>> getAll(){
		try{
			List<CityDto> citiesDto = new ArrayList<CityDto>();
			for(City city : cityDao.findAll()){
				citiesDto.add(city.toCityDto());
			}
			return new ResponseEntity<List<CityDto>>(citiesDto,HttpStatus.OK);
		}catch(Exception ex){
			return new ResponseEntity<List<CityDto>>(new ArrayList<CityDto>(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<CityDto> getById(@PathVariable Long id){
		return new ResponseEntity<CityDto>(cityDao.findById(id).get().toCityDto(), HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public @ResponseBody ResponseEntity<List<CityDto>> getByNameStartingWith(@PathVariable String name){
		List<CityDto> citiesDto = new ArrayList<CityDto>();
		
		for(City city : cityDao.findByNameStartingWith(name)){
			citiesDto.add(city.toCityDto());
		}
		return new ResponseEntity<List<CityDto>>(citiesDto,HttpStatus.OK);
	}
		
	@GetMapping("/postCode/{postCode}")
	public @ResponseBody ResponseEntity<List<CityDto>> getByPostCode(@PathVariable Integer postCode){
		List<CityDto> citiesDto = new ArrayList<CityDto>();
		List<City> cities = cityDao.findByPostCode(postCode);
		for(City city : cities){
			citiesDto.add(city.toCityDto());
		}
		return new ResponseEntity<List<CityDto>>(citiesDto,HttpStatus.OK);
	}
		
	@PutMapping("/update")
	public @ResponseBody ResponseEntity<CityDto> update(@RequestBody City city) {
		try {		
			cityDao.save(city);
		}catch (Exception ex) {
			return new ResponseEntity<CityDto>(new CityDto(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<CityDto>(city.toCityDto(),HttpStatus.OK);
	}
	
	@PutMapping("/{idCity}/addPlace/{idPlace}")
	public @ResponseBody ResponseEntity<CityDto> addPlace(@PathVariable Long idCity, @PathVariable Long idPlace){
		City city;
		try {
			city = cityDao.findById(idCity).get();
			Place place = placeDao.findById(idPlace).get();			
			place.setCity(city);
			placeDao.save(place);
			city.getPlaces().add(place);			
		}catch(Exception ex){
			return new ResponseEntity<CityDto>(new CityDto(), HttpStatus.BAD_REQUEST);
		}	
		return new ResponseEntity<CityDto>(city.toCityDto(), HttpStatus.OK);
	}

	@PutMapping("/{idCity}/removePlace/{idPlace}")
	public @ResponseBody ResponseEntity<CityDto> removePlace(@PathVariable Long idCity, @PathVariable Long idPlace){
		City city;
		try {
			city = cityDao.findById(idCity).get();
			Place place = placeDao.findById(idPlace).get();			
			city.getPlaces().remove(place);		
			cityDao.save(city);
		}catch(Exception ex){
			return new ResponseEntity<CityDto>(new CityDto(), HttpStatus.BAD_REQUEST);
		}	
		return new ResponseEntity<CityDto>(city.toCityDto(), HttpStatus.OK);
	}
}
