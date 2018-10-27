package taa.springboot.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import taa.springboot.domain.User;

@Transactional
@Component
public interface UserDao extends JpaRepository<User, Long>{
	
	@Query("from User as u where u.pseudo = :pseudo")
	public Optional<User> findByPseudo(@Param("pseudo") String pseudo);
	
	@Query("from User as u where u.pseudo = :pseudo and u.password = :password")
	public Optional<User> findByPseudoAndPassword(@Param("pseudo") String pseudo, @Param("password") String password);
}