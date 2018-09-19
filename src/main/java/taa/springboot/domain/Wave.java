package taa.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Wave {
	
	private long idWave;
	private String label;
	
	
	public Wave() {
		super();
	}

	public Wave(String label) {
		super();
		this.label = label;
	}

	@Id
    @GeneratedValue
	public long getIdWave() {
		return idWave;
	}

	public void setIdWave(long idWave) {
		this.idWave = idWave;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Wave [idWave=" + idWave + ", label=" + label + "]";
	}
	
	

}
