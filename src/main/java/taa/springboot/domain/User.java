package taa.springboot.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import taa.springboot.dto.UserDto;

@Entity
public class User implements UserDetails{

    private Long idUser;

    private String pseudo;

    private String password;
    
    private String mail;
    
    private boolean enabled;
    
    private String role;
    
    private Set<Place> places;
    
    public User() {
        super();
    }

    public User(String pseudo, String password, String mail, boolean enabled, String role) {
		super();
		this.pseudo = pseudo;
		this.password = password;
		this.mail = mail;
		this.enabled = enabled;
		this.role = role;
	}

	@Id
    @GeneratedValue
    public Long getIdUser() {
		return idUser;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	@Column(nullable = false, unique = true)
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
	
	public UserDto toUserDto(){
    	UserDto userDto = new UserDto();
    	userDto.setIdUser(this.getIdUser());
    	userDto.setPseudo(this.getPseudo());
    	userDto.setPassword(this.getPassword());
    	userDto.setMail(this.getMail());
    	userDto.setEnabled(this.isEnabled());
    	userDto.setRole(this.getRole());
    	Set<Long> idPlaces = new HashSet<Long>();
    	for(Place place : this.getPlaces()){
    		idPlaces.add(place.getIdPlace());
    	}
    	userDto.setIdPlaces(idPlaces);
    	return userDto;
    }

	
	@Override
	public String toString(){
		  return "User [idUser=" + idUser + ", pseudo=" + pseudo +
				  	", password="+ password + ", mail=" + mail + 
				  	", enalbled=" + enabled + ", role=" + role+ "]";
	}

	@Override
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	@Override
	@Transient
	public String getUsername() {
		return pseudo;
	}

	@Override
	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}
}

