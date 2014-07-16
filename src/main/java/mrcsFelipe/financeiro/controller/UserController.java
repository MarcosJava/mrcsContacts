package mrcsFelipe.financeiro.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import mrcsFelipe.financeiro.entity.Role;
import mrcsFelipe.financeiro.entity.User;
import mrcsFelipe.financeiro.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("request")
public class UserController {

	@Autowired
	private UserService userService;
	

	@RequestMapping(value="/registreUser", method={RequestMethod.POST, RequestMethod.PUT})
	public ModelAndView registreUser(@RequestParam("confirmPass") String confirmPassword,
									 @Valid User user,
									 BindingResult bindingResult,
									 HttpSession session,
									 Locale locale) {
		
		ModelAndView resultError = new ModelAndView("createUser");
		ModelAndView resultSuccess = new ModelAndView("protected/user/welcomeUser");
		
		//Utilizando o Hibernate-Validate
		//Use hibernate validate
		if(bindingResult.hasErrors()){
			Map<String, Object> model =	new HashMap<String, Object>();
			model.put("user", user);
			resultError.addAllObjects(model);
			return resultError;
		}
		
		//Verificando as senhas
		//Check the passwords
		if(!confirmPassword.equals(user.getPassword())){
			resultError.addObject("errors", "Senha e Confimar Senha estão errados !");
			return resultError;
		}
		
		User compareUser = userService.findByEmail(user.getEmail());
		if(compareUser != null){
			resultError.addObject("errors", "Usuário já existe !");
			return resultError;
		}
		
		user.setRole(Role.ROLE_USER);
		user.setPassword(org.apache.commons.codec.digest.DigestUtils.sha256Hex(confirmPassword));
		user.setEnabled(true);
		System.out.println(user);
		userService.save(user);
		session.setAttribute("user", user);
		resultSuccess.addObject("success", "Cadastrado com sucesso !");
		return resultSuccess;
	}
}
