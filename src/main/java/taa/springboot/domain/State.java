package taa.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class State {

	private long idState;
	private String label;
	
	public State() {
		super();
	}
	
	public State(String label) {
		super();
		this.label = label;
	}

	@Id
    @GeneratedValue
	public long getIdState() {
		return idState;
	}

	public void setIdState(long idState) {
		this.idState = idState;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "State [idState=" + idState + ", label=" + label + "]";
	}
	
	
		
}
