package taa.springboot.dto;

import java.util.Set;

public class PlaceDto {
	private Long idPlace;

    private String name;
    
    private String address;

    private Long idCity;
    
    private Set<Long> idUsers;

    private Set<Long> idActivities;
    

	public PlaceDto(){
		super();
    }
    
	public PlaceDto(String name, String address, Long idCity) {
		super();
		this.name = name;
		this.setAddress(address);
		this.idCity = idCity;
	}

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
	
    public Long getIdCity() {
    	return this.idCity;
    }

    public void setIdCity(Long idCity) {
    	this.idCity = idCity;
    }
  	
	public Set<Long> getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(Set<Long> idUsers) {
		this.idUsers = idUsers;
	}

	public Set<Long> getIdActivities() {
		return idActivities;
	}

	public void setIdActivities(Set<Long> idActivities) {
		this.idActivities = idActivities;
	}

	@Override
    public String toString() {
        return "Place [idPlace=" + idPlace + ", name=" + name +
        		", idCity=" + idCity + "]";
    }
}
