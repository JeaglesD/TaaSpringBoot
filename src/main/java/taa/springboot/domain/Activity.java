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
	private String label;
	private Set <Weather> weathers;;
	private Set <User> users;
	private Set <Place> places;
	
	public Activity() {
		super();
	}


	public Activity(String label) {
		this.label=label;
	}


	@Id
	@GeneratedValue
	public Long getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Long idActivity) {
		this.idActivity = idActivity;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	@ManyToMany
	@JoinTable(name="ActivityWeather",
	joinColumns= { @JoinColumn(name = "idActivity")},
	inverseJoinColumns= {@JoinColumn(name = "idWeather")})
	public Set<Weather> getWeathers() {
		return weathers;
	}




	public void setWeathers(Set<Weather> weathers) {
		this.weathers = weathers;
	}


	@ManyToMany
	@JoinTable(name="ActivityUser",
	joinColumns= { @JoinColumn(name = "idActivity")},
	inverseJoinColumns= {@JoinColumn(name = "idUser")})
	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
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
		activityDto.setLabel(this.getLabel());
		Set<Long> idUsers = new HashSet<Long>();
		for(User user : this.getUsers()){
			idUsers.add(user.getIdUser());			
		}
		activityDto.setIdUsers(idUsers);
		
		Set<Long> idPlaces = new HashSet<Long>();
		for(Place place : this.getPlaces()){
			idPlaces.add(place.getIdPlace());			
		}
		activityDto.setIdPlaces(idPlaces);
		
		Set<Long> idWeathers = new HashSet<Long>();
		for(Weather weather : this.getWeathers()){
			idWeathers.add(weather.getIdWeather());			
		}
		activityDto.setIdWeathers(idWeathers);
		
		return activityDto;
		
	}

	@Override
	public String toString() {
		return "Activity [idActivity=" + idActivity + ", label=" + label + ", Weathers="
				+ weathers.toString() + "]";
	}







}