package mrcsFelipe.financeiro.security;

import java.util.Collection;
import java.util.List;

import mrcsFelipe.financeiro.entity.Role;
import mrcsFelipe.financeiro.entity.User;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class SFAuthentication implements Authentication	{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private final User user;
	private List<User> users;
	private boolean permission;
	private Role role;
	
	public SFAuthentication(User user, Role role) {
		this.user = user;
		this.role = role;
	}
	
	public String getName() {
		if(this.user != null){
			return user.getEmail();
		} else {
			return null;
		}
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return users;
	}

	public Object getCredentials() {
		if(user != null){
			return user.getPassword();
		}
		return null;
	}

	public Object getDetails() {
		return user;
	}

	public Object getPrincipal() {
		return user != null ? user.getEmail() : null;
	}

	public boolean isAuthenticated() {
		return permission;
	}

	public void setAuthenticated(boolean permission) throws IllegalArgumentException {
		this.permission = permission; 
	}

}
