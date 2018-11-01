package taa.springboot.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import taa.springboot.domain.Activity;

@Transactional
@Component
public interface ActivityDao  extends JpaRepository <Activity, Long>{
	
	@Query("from Activity a where a.name = :name")
	public List<Activity> findByName(@Param("name") String name);
	
	
}