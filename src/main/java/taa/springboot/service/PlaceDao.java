package taa.springboot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import taa.springboot.domain.Place;

@Transactional
@Component
public interface PlaceDao extends JpaRepository<Place, Long>{
	
	@Query("from Place as p where p.postCode = :postCode")
	public Place findByPostCode(String postCode);

	@Query("from Place as p where p.name = :name")
	public Place findByName(String name);
}
