package taa.springboot.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import taa.springboot.dto.PlaceDto;

@Entity
public class Place {
	private Long idPlace;

    private String name;
    
    private String address; 
    
    private City city;
    
    private Set<User> users;

    private Set<Activity> activities;
    

	public Place() {
		super();
    }
    
	public Place(String name, String address, City city) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
	}

	@Id
    @GeneratedValue
    public Long getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Long idPlace) {
        this.idPlace = idPlace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCity")
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PlaceUser",
			joinColumns = { @JoinColumn(name = "idPlace") },
			inverseJoinColumns = { @JoinColumn(name = "idUser") })
	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	@ManyToMany
	@JoinTable( name = "ActivityPlace",
			joinColumns = { @JoinColumn(name = "idPlace") },
			inverseJoinColumns = { @JoinColumn(name = "idActivity") })
    public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}
	
	public PlaceDto toPlaceDto(){
    	PlaceDto placeDto = new PlaceDto();
    	placeDto.setIdPlace(this.getIdPlace());
    	placeDto.setName(this.getName());
    	placeDto.setAddress(this.getAddress());
    	if(this.getCity() != null) {
          	placeDto.setIdCity(this.getCity().getIdCity());
    	}
    	Set<Long> idUsers = new HashSet<Long>();
    	for(User user : this.getUsers()){
    		idUsers.add(user.getIdUser());
    	}
    	placeDto.setIdUsers(idUsers);
    	
    	
    	Set<Long> idActivities = new HashSet<Long>();
    	for(Activity activity : this.getActivities()){
    		idActivities.add(activity.getIdActivity());
    	}
    	placeDto.setIdActivities(idActivities);
    	return placeDto;
    }
	
	@Override
    public String toString() {
		return "Place [idPlace=" + idPlace + ", name=" + name +
        		", city=" + city.toString() + "]";
	}
}
