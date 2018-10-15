package taa.springboot.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import taa.springboot.domain.City;

public interface CityDao extends JpaRepository<City, Long>{
	@Query("from City c where c.postCode = :postCode")
	public List<City> findByPostCode(@Param("postCode") Integer postCode);

	@Query("from City c where c.name = :name")
	public List<City> findByName(@Param("name") String name);
	
	@Query("from City c where c.name = :name and c.postCode = :postCode")	
	public City findByNameAndCodePost(@Param("name") String name, @Param("postCode") Integer postCode);
}
