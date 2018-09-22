package taa.springboot.dto;

import java.util.Set;

public class PlaceDto {
	private Long idPlace;

    private String name;

    private Integer postCode;
    
    private Set<Long> idUsers;

    private Set<Long> idActivities;
    

	public PlaceDto(){
		super();
    }
    
	public PlaceDto(String name, Integer postCode) {
		super();
		this.name = name;
		this.postCode = postCode;
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

    public Integer getPostCode(){
		return postCode;
	}

	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
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
        return "Place [idPlace=" + idPlace + ", name=" + name + ", postCode="
                + postCode + "]";
    }
}
