package taa.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Weather {
	
	private long idWeather;
	private float temperature;
	private State state;
	private Snow snow;
	private Wind wind;
	private Wave wave;
	
	public Weather(){
		super();
	}
	
	public Weather(float temperature, State state, Snow snow, Wind wind, Wave wave) {
		super();
		this.temperature = temperature;
		this.state = state;
		this.snow = snow;
		this.wind = wind;
		this.wave = wave;
	}
	
	@Id
    @GeneratedValue
	public long getIdWeather() {
		return idWeather;
	}
	
	public void setIdWeather(long idWeather) {
		this.idWeather = idWeather;
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	@ManyToOne
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	@ManyToOne
	public Snow getSnow() {
		return snow;
	}

	public void setSnow(Snow snow) {
		this.snow = snow;
	}
	
	@ManyToOne
	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	@ManyToOne
	public Wave getWave() {
		return wave;
	}

	public void setWave(Wave wave) {
		this.wave = wave;
	}

	@Override
	public String toString() {
		return "Weather [idWeather=" + idWeather + ", temperature=" + temperature + ", state=" + state + ", snow="
				+ snow + ", wind=" + wind + ", wave=" + wave + "]";
	}
	
	
	
}


