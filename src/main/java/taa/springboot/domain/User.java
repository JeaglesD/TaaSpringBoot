package taa.springboot.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {

    private Long idUser;

    private String pseudo;

    private String password;
    
    private String mail;
    
    private List<Place> places = new ArrayList<Place>();

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
	public List<Place> getPlaces() {
		return places;
	}


	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	
	@Override
	public String toString(){
		  return "User [idUser=" + idUser + ", pseudo=" + pseudo + ", password="
	                + password + ", mail=" + mail + "]";
	}
}

