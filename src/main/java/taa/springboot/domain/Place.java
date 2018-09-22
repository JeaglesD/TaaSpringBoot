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

import taa.springboot.dto.PlaceDto;

@Entity
public class Place {
	private Long idPlace;

    private String name;

    private Integer postCode;
    
    private Set<User> users;

    private Set<Activity> activities;
    

	public Place() {
    }
    
	public Place(String name, Integer postCode) {
		super();
		this.name = name;
		this.postCode = postCode;
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

    public Integer getPostCode(){
		return postCode;
	}

	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
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
    	placeDto.setPostCode(this.getPostCode());
    	    	
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
        return "Place [idPlace=" + idPlace + ", name=" + name + ", postCode="
                + postCode + "]";
    }
}
