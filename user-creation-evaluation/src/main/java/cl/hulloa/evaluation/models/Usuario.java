package cl.hulloa.evaluation.models;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    @NotBlank
	private String nombre;
	

    @NotNull
    @NotBlank
	@Column(name="email", unique = true)
	private String email;


    @NotNull
    @NotBlank
	private String password;
	
	@Column(name="created")
	private String created;
	private String modified;

	@Column(name = "last_login")
	private String lastLogin;
	
	private boolean isActive;
	
	private String token;
	
	@OneToMany(fetch= FetchType.LAZY, mappedBy="user", cascade = CascadeType.ALL)
	private List<Phone> phones;
	
	public Usuario() {
		
	}
	

	public Usuario(String nombre, String email, String password, List<Phone> phones) {
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.phones = phones;
		
	}



	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public List<Phone> getPhones() {
		return phones;
	}



	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", created='" + created + '\'' +
				", modified='" + modified + '\'' +
				", lastLogin='" + lastLogin + '\'' +
				", isActive=" + isActive +
				", token='" + token + '\'' +
				", phones=" + phones +
				'}';
	}
}
