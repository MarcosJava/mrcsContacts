package mrcsFelipe.financeiro.security;

import mrcsFelipe.financeiro.entity.User;
import mrcsFelipe.financeiro.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class SFAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private UserRepository userRepository;
	
	public Authentication authenticate(Authentication authentication)throws AuthenticationException {
		
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		
		String email = token.getName();
		String password = "";
		
		if(token.getCredentials() != null){
			password = token.getCredentials().toString();
		}else{
			password = null;
		}
		
		User user = userRepository.findByEmailAndPassword(email, password);
		System.out.println("syso -- authentic = " +user);
		if(user == null){
			return null;
		}
		SFAuthentication result = new SFAuthentication(user, user.getRole());
		result.setAuthenticated(user != null);
		return result;
		
	}

	public boolean supports(Class<?> object) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(object));
	}

}
