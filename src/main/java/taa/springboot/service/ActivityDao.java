package taa.springboot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import taa.springboot.domain.Activity;


@Transactional
@Component
public interface ActivityDao  extends JpaRepository <Activity, Long>{
	
	@Query("from Activity a where Activity.label = :label")
	public Activity findByPseudo(@Param("label") String label);
	
	
}
