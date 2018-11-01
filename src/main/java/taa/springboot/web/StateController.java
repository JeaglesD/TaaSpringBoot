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
//import taa.springboot.domain.State;
//import taa.springboot.service.StateDao;
//
//@RestController
//@RequestMapping("/api/state")
//public class StateController {
//
//	@Autowired
//	private StateDao stateDao;
//	
//	@PostMapping("/create")
//	public @ResponseBody ResponseEntity<String> create(@RequestBody State state){
//		try {
//			stateDao.save(state);
//		}catch(Exception e) {
//			return new ResponseEntity<String>("POST Response", HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<String>("POST Response", HttpStatus.OK);
//
//	
//	@DeleteMapping("/delete/{id}")
//	public @ResponseBody ResponseEntity<String> delete(@PathVariable String id){
//		try {
//			stateDao.delete(stateDao.findById(Long.parseLong(id)).get());
//		} catch (Exception ex) {
//			return new ResponseEntity<String>("DELETE Response", HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
//	}
//	
//	@GetMapping("/{id}")
//	public @ResponseBody ResponseEntity<State> getById(@PathVariable String id){
//		return new ResponseEntity<State>(stateDao.findById(Long.parseLong(id)).get(), HttpStatus.OK);
//	}
//	
//	@PutMapping("/update")
//	public @ResponseBody ResponseEntity<String> update(@RequestBody State state){
//		try {
//			stateDao.save(state);
//		}catch( Exception ex) {
//			return new ResponseEntity<String>("PUT Response",HttpStatus.BAD_REQUEST);		
//		}
//		return new ResponseEntity<String>("PUT Response",HttpStatus.OK);
//	}
//	
//}
