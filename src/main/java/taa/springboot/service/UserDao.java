package taa.springboot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import taa.springboot.domain.User;

@Transactional
@Component
public interface UserDao extends JpaRepository<User, Long>{
	
	@Query("from User u where u.pseudo = :pseudo")
	public User findByPseudo(@Param("pseudo") String pseudo);
	
	
}
