package taa.springboot;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import taa.springboot.SpringbootApplication;
import taa.springboot.service.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class SpringbootApplicationTests {

	@Autowired
	UserDao dao;
	
	
	@Test
	public void exampleTest() {
		
		assertTrue(true);
//		this.webClient.get().uri("/users/2").exchange().expectStatus().isOk();
	}

}
