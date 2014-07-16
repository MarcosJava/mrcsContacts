package mrcsFelipe.financeiro.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

@Entity @Table(name = "system_user")
public class User implements GrantedAuthority, java.io.Serializable {
	
	public final static String SEQUENCE_NAME = "user_id_sequence";
	
	@Id @GeneratedValue 
	@SequenceGenerator(name=User.SEQUENCE_NAME, 
					   sequenceName=User.SEQUENCE_NAME,
					   initialValue=1, allocationSize=50)
	private int id;
	
	@Column(unique=true,nullable=false, length=128)
	@Email @NotNull @NotEmpty
	private String email;
	
	@NotNull @NotEmpty
	private String name;

	@NotNull @NotEmpty @Size(min=6)
	private String password;
	
	private boolean enabled;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private Role role;
	
	@OneToMany(orphanRemoval=true, mappedBy="user")
	private List<Account> account;
	
	public User() {
		
	}
	
	
	
	public User(int id, String email, String name, String password,
			boolean enabled, Role role) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Account> getAccount() {
		return account;
	}
	
	public void setAccount(List<Account> account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name
				+ ", password=" + password + ", enabled=" + enabled + ", role="
				+ role + "]";
	}



	public String getAuthority() {
		return getRole().toString();
	}
	
	
	
}
