package taa.springboot.dto;

import java.util.Set;

public class CityDto {
	private Long idCity;
	
	private String name;
	
	private Integer postCode;
	
	private Set<Long> idPlaces;

	public CityDto() {
		super();
	}

	public CityDto(String name, Integer postCode) {
		super();
		this.name = name;
		this.postCode = postCode;
	}

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

	public Set<Long> getPlaces() {
		return idPlaces;
	}

	public void setPlaces(Set<Long> idPlaces) {
		this.idPlaces = idPlaces;
	}
	
	@Override
	public String toString() {
		return "City [idCity=" + idCity + ", name=" + name +", postCode=" + postCode +"]";
	}
	
}
