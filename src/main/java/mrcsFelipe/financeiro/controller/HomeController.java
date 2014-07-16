package mrcsFelipe.financeiro.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import mrcsFelipe.financeiro.entity.User;
import mrcsFelipe.financeiro.service.AccountService;
import mrcsFelipe.financeiro.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("request")
public class HomeController {
	
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	
	//Redirect
	@RequestMapping("/")
    public String redirect(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(auth.getAuthorities());
		
		if (auth.getName().equals("anonymousUser")) {
			return "login";
		}
		
        if(!auth.getName().equals(" ") || auth.getName() != null){
        	return "user/home";
        }
        
        return null;
 
    }
	
	//Redirect
	@RequestMapping("/admin")
	public String redirectAdm(){
	    return "admin/home";
	}
	
	//Redirect
	@RequestMapping("/user")
	public String redirectUser(){
	    return "user/home";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//Redirect -- Home
	@RequestMapping("/home")
	public String home(){
	   return "redirect:/";
	}
	
	@RequestMapping("/createUser")
	public String registrar() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", new User());
		return "createUser";
	}
	
	@RequestMapping("/contactMe")
	public String contactMe(){
		return "contactMe";
	}
	
	/*********************************************************************
	 * 
	 * ACCOUNT
	 * 
	 *********************************************************************/
	
	
	@RequestMapping("/user/createAccount")
	public String createAccount(){
		return "user/createAccount";
	}
	
	@RequestMapping(value="/user/accounts", method=RequestMethod.GET)
	public ModelAndView lstAccount(){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user  = userService.findByEmail(auth.getName());
		
		ModelAndView mav = new ModelAndView("user/accounts");
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("lstAccount", accountService.findAll(user.getId()) );
		mav.addAllObjects(modelMap);
		return mav ;
	}
	
	/*********************************************************************
	 * 
	 * RELEASE
	 * 
	 *********************************************************************/
	
	
	@RequestMapping(value="user/createRelease")
	public ModelAndView createRelease(){
		
		ModelAndView view = new ModelAndView("user/createRelease");
		
		System.out.println("oie");
		
		return view;
	}
	
	
	
	
}
