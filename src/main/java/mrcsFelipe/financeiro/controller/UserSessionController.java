package mrcsFelipe.financeiro.controller;

import mrcsFelipe.financeiro.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class UserSessionController {
	
	@RequestMapping("/user/autenticado")
	public ModelAndView infoAutenticado(@ModelAttribute("user") User usuario){
		ModelAndView mav = new ModelAndView("user/show");
		mav.getModel().put("user", usuario);
		return mav;
	}
	
	
}
