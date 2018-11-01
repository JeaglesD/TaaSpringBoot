package taa.springboot.dto;

import java.util.Set;

public class ActivityDto {
	private Long idActivity;
	private String name;
	private Double minTemp;
	private Double maxTemp;
	private Set <Long> idPlaces;
	
	public ActivityDto() {
	       super();
	}

	public ActivityDto(String name, Double minTemp, Double maxTemp) {
		super();
		this.name = name;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
	}
	
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

	public Set<Long> getIdPlaces() {
		return idPlaces;
	}

	public void setIdPlaces(Set<Long> idPlaces) {
		this.idPlaces = idPlaces;
	}
	
	@Override
	public String toString() {
		return "Activity [idActivity=" + idActivity + ", name=" + name + ", minTemp="
				+ minTemp.toString() + " maxTemp=" + maxTemp.toString() + "]";
	}
}
