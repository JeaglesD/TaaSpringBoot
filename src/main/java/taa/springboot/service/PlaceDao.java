package taa.springboot.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import taa.springboot.domain.Place;

@Transactional
@Component
public interface PlaceDao extends JpaRepository<Place, Long>{
	
	@Query("from Place p where p.name = :name")
	public List<Place> findByName(@Param("name") String name);
	
}
