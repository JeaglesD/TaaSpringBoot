package taa.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Snow {

	private long idSnow;
	private String label;
	
	public Snow() {
		super();
	}
	
	public Snow(String label) {
		super();
		this.label = label;
	}

	@Id
    @GeneratedValue
	public long getIdSnow() {
		return idSnow;
	}

	public void setIdSnow(long idSnow) {
		this.idSnow = idSnow;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return "Snow [idSnow=" + idSnow + ", label=" + label + "]";
	}
		
}
