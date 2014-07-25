package mrcsFelipe.financeiro.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
		ModelAndView resultSuccess = new ModelAndView("successUser");
		
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
			Map<String, Object> model =	new HashMap<String, Object>();
			model.put("user", user);
			model.put("errors", "Senha e Confirmar Senha estão errados !");
			resultError.addAllObjects(model);
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
	
	
	/*
	 * RESGATANDO IMAGEM
	 */
	
	@RequestMapping("/user/avatar")
	@ResponseBody
	public byte[] avatar() throws IOException {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		File arquivo = new File("/home/marcos/financeiro/avatar/"+auth.getName().trim()+".png");
		
		if (! arquivo.exists()) {
			arquivo = new File("/home/marcos/financeiro/avatar/125x125.jpg");
		}
		if(!arquivo.exists()){
			arquivo = new File("E:/PROJETOS/FinanceiroMrcsFelipe/Avatares/"+auth.getName().trim()+".png");
			
			if(!arquivo.exists()){
				arquivo = new File("E:/PROJETOS/FinanceiroMrcsFelipe/Avatares/125x125.jpg");
			}
		}
		
		byte[] resultado = new byte[(int)arquivo.length()];
		FileInputStream input = new FileInputStream(arquivo);
		input.read(resultado);
		input.close();
		
		return resultado;
	}
	
	
	/**
	 * 
	 * CREATING IMAGEM
	 * 
	 */
	
	@RequestMapping("/user/avatar/create")
	private String createAvatar(@RequestParam("avatar")MultipartFile avatar) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		File dir = new File("/home/marcos/financeiro/avatar/");
		
		if(!dir.exists()){
			dir = new File("E:/PROJETOS/FinanceiroMrcsFelipe/Avatares");
		}
		
		if (! dir.exists()) {
			dir.mkdirs();
		}
			try {
				FileOutputStream arquivo = new FileOutputStream(
						dir.getAbsolutePath() + "/" + auth.getName().trim() + ".png");
				
				arquivo.write(avatar.getBytes());
				arquivo.close();
			} catch (IOException ex) {
				
			}
		return "user/perfil";
	}
	
	
	
	/***
	 * 
	 * Total de cada conta
	 * 
	 */
	@RequestMapping("/user/totalAccount/{id}")
	@ResponseBody
	public Integer totalAccount(@PathVariable("id")String id){
		
		Integer i = Integer.parseInt(id);
		
		return i;
	}
	
}
