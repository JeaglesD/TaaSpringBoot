package taa.springboot.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import taa.springboot.dto.UserDto;

@Entity
public class User {

    private Long idUser;

    private String pseudo;

    private String password;
    
    private String mail;
    
    private Set<Place> places;

    public User() {
        super();
    }
  

    public User(String pseudo, String password, String mail) {
		super();
		this.pseudo = pseudo;
		this.password = password;
		this.mail = mail;
	}

    @Id
    @GeneratedValue
    public Long getIdUser() {
		return idUser;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PlaceUser",
			joinColumns = { @JoinColumn(name = "idUser") },
			inverseJoinColumns = { @JoinColumn( name = "idPlace") })
	public Set<Place> getPlaces() {
		return places;
	}


	public void setPlaces(Set<Place> places) {
		this.places = places;
	}
	
	public  UserDto toUserDto(){
    	UserDto userDto = new UserDto();
    	userDto.setIdUser(this.getIdUser());
    	userDto.setPseudo(this.getPseudo());
    	userDto.setPassword(this.getPassword());
    	userDto.setMail(this.getMail());
    	
    	Set<Long> idPlaces = new HashSet<Long>();
    	for(Place place : this.getPlaces()){
    		idPlaces.add(place.getIdPlace());
    	}
    	userDto.setIdPlaces(idPlaces);
    	return userDto;
    }
	
	@Override
	public String toString(){
		  return "User [idUser=" + idUser + ", pseudo=" + pseudo + ", password="
	                + password + ", mail=" + mail + "]";
	}
}

