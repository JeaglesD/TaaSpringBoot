//package taa.springboot.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import taa.springboot.domain.Snow;
//import taa.springboot.service.SnowDao;
//
//@RestController
//@RequestMapping("/api/snow")
//public class SnowController {
//
//	@Autowired
//	private SnowDao snowDao;
//	
//	@PostMapping("/create")
//	public @ResponseBody ResponseEntity<String> create(@RequestBody Snow snow){
//		try {
//			snowDao.save(snow);
//		}catch(Exception e) {
//			return new ResponseEntity<String>("POST Response", HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<String>("POST Response", HttpStatus.OK);
//	}
//	a
//	@DeleteMapping("/delete/{id}")
//	public @ResponseBody ResponseEntity<String> delete(@PathVariable String id){
//		try {
//			snowDao.delete(snowDao.findById(Long.parseLong(id)).get());
//		} catch (Exception ex) {
//			return new ResponseEntity<String>("DELETE Response", HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
//	}
//	
//	@GetMapping("/{id}")
//	public @ResponseBody ResponseEntity<Snow> getById(@PathVariable String id){
//		return new ResponseEntity<Snow>(snowDao.findById(Long.parseLong(id)).get(), HttpStatus.OK);
//	}
//	
//	@PutMapping("/update")
//	public @ResponseBody ResponseEntity<String> update(@RequestBody Snow snow){
//		try {
//			snowDao.save(snow);
//		}catch( Exception ex) {
//			return new ResponseEntity<String>("PUT Response",HttpStatus.BAD_REQUEST);		
//		}
//		return new ResponseEntity<String>("PUT Response",HttpStatus.OK);
//	}
//	
//}
