package taa.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Wind {
	
	private long idWind;
	private String label;
	
	public Wind() {
		super();
	}
	
	public Wind(String label) {
		super();
		this.label = label;
	}

	@Id
    @GeneratedValue
	public long getIdWind() {
		return idWind;
	}


	public void setIdWind(long idWind) {
		this.idWind = idWind;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Wind [idWind=" + idWind + ", label=" + label + "]";
	}
	
	
	
	
}
