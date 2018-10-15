package taa.springboot.dto;

import java.util.Set;

public class UserDto {

    private Long idUser;

    private String pseudo;

    private String password;
    
    private String mail;
    
    private Set<Long> idPlaces;

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

	
	public Set<Long> getIdPlaces() {
		return idPlaces;
	}


	public void setIdPlaces(Set<Long> idPlaces) {
		this.idPlaces = idPlaces;
	}


	@Override
	public String toString(){
		  return "User [idUser=" + idUser + ", pseudo=" + pseudo + ", password="
	                + password + ", mail=" + mail + "]";
	}
}

