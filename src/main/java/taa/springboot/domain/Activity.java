package taa.springboot.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import taa.springboot.dto.ActivityDto;

import javax.persistence.JoinColumn;

@Entity
public class Activity {
	private Long idActivity;
	private String name;
	private Double minTemp;
	private Double maxTemp;
	private Set <Place> places;
	
	public Activity() {
		super();
	}


	public Activity(String name,Double minTemp, Double maxTemp){
		this.name = name;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
	}

	@Id
	@GeneratedValue
	public Long getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Long idActivity) {
		this.idActivity = idActivity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Double getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(Double minTemp) {
		this.minTemp = minTemp;
	}

	public Double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(Double maxTemp) {
		this.maxTemp = maxTemp;
	}

	@ManyToMany
	@JoinTable(name="ActivityPlace",
	joinColumns= {@JoinColumn(name="idActivity")},
	inverseJoinColumns= {@JoinColumn(name = "idPlace")})
	public Set<Place> getPlaces() {
		return places;
	}


	public void setPlaces(Set<Place> places) {
		this.places = places;
	}
	
	public ActivityDto toActivityDto(){
		ActivityDto activityDto = new ActivityDto();
		activityDto.setIdActivity(this.getIdActivity());
		activityDto.setName(this.getName());
		activityDto.setMinTemp(this.getMinTemp());
		activityDto.setMaxTemp(this.getMaxTemp());
		Set<Long> idPlaces = new HashSet<Long>();
		for(Place place : this.getPlaces()){
			idPlaces.add(place.getIdPlace());			
		}
		activityDto.setIdPlaces(idPlaces);
				
		return activityDto;
		
	}

	@Override
	public String toString() {
		return "Activity [idActivity=" + idActivity + ", name=" + name + ", minTemp="
				+ minTemp.toString() + " maxTemp=" + maxTemp.toString() + "]";
	}







}