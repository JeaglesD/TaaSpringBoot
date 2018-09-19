package taa.springboot.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Place {
	private Long idPlace;

    private String name;

    private Integer postCode;
    
    private List<User> users = new ArrayList<User>();

    private List<Activity> activities = new ArrayList<Activity>();
    

	public Place() {
    }
    
	public Place(String name, Integer postCode) {
		super();
		this.name = name;
		this.postCode = postCode;
	}

	public Place(String name) {
        this.name = name;
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
	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@ManyToMany
	@JoinTable( name = "ActivityPlace",
			joinColumns = { @JoinColumn(name = "idPlace") },
			inverseJoinColumns = { @JoinColumn(name = "idActivity") })
    public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
	@Override
    public String toString() {
        return "Place [idPlace=" + idPlace + ", name=" + name + ", postCode="
                + postCode + "]";
    }
}
