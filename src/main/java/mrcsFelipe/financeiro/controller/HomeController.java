package mrcsFelipe.financeiro.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import mrcsFelipe.financeiro.entity.Account;
import mrcsFelipe.financeiro.entity.FinancialRelease;
import mrcsFelipe.financeiro.entity.User;
import mrcsFelipe.financeiro.service.AccountService;
import mrcsFelipe.financeiro.service.FinancialReleaseService;
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
	
	@Autowired
	private FinancialReleaseService financialReleaseService;
	
	private Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
	//Redirect
	@RequestMapping("/")
    public ModelAndView redirect(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(auth.getAuthorities());
		
		ModelAndView view = new ModelAndView();
		
		if (auth.getName().equals("anonymousUser")) {
			view.setViewName("login");
			return view;
		}
		
        if(!auth.getName().equals(" ") || auth.getName() != null){
        	
        
        	
        	List<Account> accounts = this.accountService.findAll(this.auth.getName());
    		List<FinancialRelease> releases = this.financialReleaseService.findAllReleaseByUser(this.auth.getName());
    		
    		
    		//Getting total em cada Account -- Total dos lançamentos + do start da conta
    		for(int i = 0 ; i < accounts.size() ; i++){
    			Integer id = accounts.get(i).getId();
    			BigDecimal total = this.accountService.totalInAccount(id);
    			if(total == null){
    				total = accounts.get(i).getAmountStart();
    			}
    			accounts.get(i).setTotal(total);
    		}
    		
    		//Getting Total Amount Start
    		BigDecimal totalAmountStartAllAccount = this.accountService.amountStartTotalAllAccount(this.auth.getName());
    		
    		//Getting Everytotal Amount + Release 
    		BigDecimal totalAllAccountAndRelease = this.accountService.totalAllAccountAndRelease(this.auth.getName());
    		
    		//Total Release for User
    		BigDecimal totalReleaseByUser = this.financialReleaseService.totalReleaseByUser(this.auth.getName());
    		
    		//Getting User
    		User user = this.userService.findByEmail(this.auth.getName());
    		
    		view.setViewName("user/home");
    		Map<String, Object> maps = new HashMap<String, Object>();
    		maps.put("user", user);
    		maps.put("accounts", accounts );
    		maps.put("releases",releases );
    		maps.put("totalStartAmount", totalAmountStartAllAccount);
    		maps.put("totalReleaseAccount", totalAllAccountAndRelease);
    		maps.put("totalReleaseByUser", totalReleaseByUser );
    		view.addAllObjects(maps);
    		return view;

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
	
	
	@RequestMapping("/createUser")
	public String registrar() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", new User());
		return "createUser";
	}
	
	@RequestMapping("/createUser/success")
	public String registrarSuccess() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", new User());
		return "createUser/success";
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
		
		
		User user  = userService.findByEmail(this.auth.getName());
		
		ModelAndView mav = new ModelAndView("user/accounts");
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("lstAccount", accountService.findAll(this.auth.getName()));
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
		
		Map<String, Object> modelView = new HashMap<String, Object>();
		modelView.put("accounts", accountService.findAll(this.auth.getName()));		
		view.addAllObjects(modelView);
		
		return view;
	}
	
	/*********************************************************************
	 * 
	 * Perfil
	 * 
	 *********************************************************************/
	@RequestMapping("user/perfil")
	public ModelAndView perfil(){
		
		User user = this.userService.findByEmail(this.auth.getName());
		
		ModelAndView view = new ModelAndView("user/perfil");
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("user", user);
		view.addAllObjects(maps);
		return view;
	}
	
}
