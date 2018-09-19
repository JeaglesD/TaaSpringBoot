package taa.springboot.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Activity {
	private Long idActivity;
	private String label;
	private List <Weather> weathers = new ArrayList <Weather>();
	private List <User> users = new ArrayList <User>();
	private List <Place> places = new ArrayList <Place>();
	
	public Activity() {
		super();
	}


	public Activity(String label,List <Place> places, List<Weather> weathers) {
		this.label=label;
		this.places=places;
		this.weathers=weathers;
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
	public List<Weather> getWeathers() {
		return weathers;
	}




	public void setWeathers(List<Weather> weathers) {
		this.weathers = weathers;
	}


	@ManyToMany
	@JoinTable(name="ActivityUser",
	joinColumns= { @JoinColumn(name = "idActivity")},
	inverseJoinColumns= {@JoinColumn(name = "idUser")})
	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}

	@ManyToMany
	@JoinTable(name="ActivityPlace",
	joinColumns= {@JoinColumn(name="idActivity")},
	inverseJoinColumns= {@JoinColumn(name = "idPlace")})
	public List<Place> getPlaces() {
		return places;
	}


	public void setPlaces(List<Place> places) {
		this.places = places;
	}


	@Override
	public String toString() {
		return "Activity [idActivity=" + idActivity + ", label=" + label + ", Weathers="
				+ weathers.toString() + "]";
	}




}