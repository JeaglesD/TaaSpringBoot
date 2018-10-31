package taa.springboot.web;

import java.security.Principal;
import java.util.Base64;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.net.SyslogOutputStream;
import taa.springboot.domain.User;
import taa.springboot.service.UserDao;

@RestController()
@RequestMapping("/api/")
public class AuthenController {

	@Autowired
	private UserDao userDao;

	
	@PostMapping("/login")
	public boolean login(@RequestBody User userToLog){
		Optional<User> user = userDao.findByPseudo(userToLog.getPseudo());
		if(user.isPresent()) {
			return user.get().getPassword().equals(userToLog.getPassword());
		}else {
			return false;
		}
		
	}
	
	@GetMapping("/user")
	public Principal user(HttpServletRequest request){
		System.out.println("request:"+request);
		String authToken = request.getHeader("Authorization")
				.substring("Basic".length()).trim();
		return () -> new String(Base64.getDecoder()
				.decode(authToken)).split(":")[0];
	}
}

