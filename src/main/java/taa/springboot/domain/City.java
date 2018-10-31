package taa.springboot.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import taa.springboot.dto.CityDto;

@Entity
public class City {
	
	private Long idCity;
	
	private String name;
	
	private Integer postCode;
	
	private Set<Place> places;
	
	public City() {
	}

	public City(String name, Integer postCode) {
		super();
		this.name = name;
		this.postCode = postCode;
	}
	
	@Id
    @GeneratedValue
	public Long getIdCity() {
		return idCity;
	}

	public void setIdCity(Long idCity) {
		this.idCity = idCity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPostCode() {
		return postCode;
	}

	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idCity")
	public Set<Place> getPlaces() {
		return places;
	}

	public void setPlaces(Set<Place> places) {
		this.places = places;
	}

	public CityDto toCityDto() {
		CityDto cityDto = new CityDto();
		cityDto.setIdCity(this.idCity);
		cityDto.setName(this.name);
		cityDto.setPostCode(this.postCode);
		Set<Long> idPlaces = new HashSet<Long>();
		for(Place place : this.getPlaces()) {
			idPlaces.add(place.getIdPlace());
		}
		cityDto.setIdPlaces(idPlaces);
		return cityDto;
	}
	
	@Override
	public String toString() {
		return "City [idCity=" + idCity + ", name=" + name +", postCode=" + postCode +"]";
	}	
}