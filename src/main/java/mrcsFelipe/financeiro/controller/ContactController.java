package mrcsFelipe.financeiro.controller;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import mrcsFelipe.financeiro.utils.GMail;
import mrcsFelipe.financeiro.vo.ContactMeVO;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("request")
public class ContactController {

	@RequestMapping(value="contactMe/sending", method={RequestMethod.POST, RequestMethod.PUT})
	public ModelAndView contactMe(@Valid ContactMeVO contactMeVO,
								  BindingResult binding){
		
		ModelAndView resultError = new ModelAndView("contactMe");
		ModelAndView resultSuccess = new ModelAndView("contactMeSuccess");
		
		try {
			
			//Utilizando o Hibernate-Validate
			//Use hibernate validate
			if(binding.hasErrors()){
				Map<String, Object> model =	new HashMap<String, Object>();
				model.put("contactMeVO", contactMeVO);
				resultError.addAllObjects(model);
				return resultError;
			}
		
		
		if(contactMeVO.getSubject().equals("none")){
			Map<String, Object> model =	new HashMap<String, Object>();
			model.put("contactMeVO", contactMeVO);
			resultError.addObject("errorzim", "Selecione algum assunto !");
			return resultError;
		}
			
		String messageReal = contactMeVO.getEmail() + "\n\n\n" + contactMeVO.getSubject() + "\n\n\n" + contactMeVO.getMessage();  
		
		GMail gmail = new GMail(contactMeVO.getEmail(), "mfelipesp@gmail.com", contactMeVO.getSubject(), messageReal);
		gmail.enviarEmail();
		
		
		return resultSuccess;
		
		} catch (Exception e) {
			e.printStackTrace();
			resultError.addObject("error", "Houve algum erro, informe ao Suporte caso persista !");
			return resultError;
		}
		
	}
	
	
	public boolean notNull(String firstName, String lastName, 
						   String email, String subject, String message){
		
		if(firstName.trim().equals("") || firstName == null){
			return false;
		}
		
		if(lastName.trim().equals("") || lastName == null){
			return false;
		}
		
		if(email.trim().equals("") || email == null){
			return false;
		}
		
		if(subject.equals("none") || subject == null){
			return false;
		}
		
		if(message.trim().equals("") || message == null){
			return false;
		}
		
		if(message.length() < 10){
			return false;
		}
		
		return true;
	}
	
}
