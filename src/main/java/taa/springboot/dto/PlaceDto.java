package taa.springboot.dto;

import java.util.ArrayList;
import java.util.List;

public class PlaceDto {
	private Long idPlace;

    private String name;

    private Integer postCode;
    
    private List<Long> idUsers = new ArrayList<Long>();

    private List<Long> idActivities = new ArrayList<Long>();
    

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

	
	public List<Long> getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(List<Long> idUsers) {
		this.idUsers = idUsers;
	}

	public List<Long> getIdActivities() {
		return idActivities;
	}

	public void setIdActivities(List<Long> idActivities) {
		this.idActivities = idActivities;
	}

	@Override
    public String toString() {
        return "Place [idPlace=" + idPlace + ", name=" + name + ", postCode="
                + postCode + "]";
    }
}
