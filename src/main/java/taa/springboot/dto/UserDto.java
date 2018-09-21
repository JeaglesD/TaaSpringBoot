package taa.springboot.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UserDto {

    private Long idUser;

    private String pseudo;

    private String password;
    
    private String mail;
    
    private List<Long> idPlaces = new ArrayList<Long>();

    public UserDto() {
        super();
    }
  

    public UserDto(String pseudo, String password, String mail) {
		super();
		this.pseudo = pseudo;
		this.password = password;
		this.mail = mail;
	}

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

	
	public List<Long> getIdPlaces() {
		return idPlaces;
	}


	public void setIdPlaces(List<Long> idPlaces) {
		this.idPlaces = idPlaces;
	}


	@Override
	public String toString(){
		  return "User [idUser=" + idUser + ", pseudo=" + pseudo + ", password="
	                + password + ", mail=" + mail + "]";
	}
}

