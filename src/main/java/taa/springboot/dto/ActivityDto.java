package taa.springboot.dto;

import java.util.Set;

public class ActivityDto {
	private Long idActivity;
	private String label;
	private Set <Long> idWeathers;;
	private Set <Long> idUsers;
	private Set <Long> idPlaces;
	
	public ActivityDto() {
	       super();
	}

	public ActivityDto(String label) {
		super();
		this.label = label;
	}
	
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

	public Set<Long> getIdWeathers() {
		return idWeathers;
	}

	public void setIdWeathers(Set<Long> idWeathers) {
		this.idWeathers = idWeathers;
	}

	public Set<Long> getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(Set<Long> users) {
		this.idUsers = users;
	}

	public Set<Long> getIdPlaces() {
		return idPlaces;
	}

	public void setIdPlaces(Set<Long> idPlaces) {
		this.idPlaces = idPlaces;
	}
	
	@Override
	public String toString() {
		return "Activity [idActivity=" + idActivity + ", label=" + label + ", Weathers="
				+ idWeathers.toString() + "]";
	}
}
