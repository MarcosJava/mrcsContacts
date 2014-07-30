package mrcsFelipe.financeiro.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import mrcsFelipe.financeiro.entity.Account;
import mrcsFelipe.financeiro.entity.FinancialRelease;
import mrcsFelipe.financeiro.entity.User;
import mrcsFelipe.financeiro.repository.UserRepository;
import mrcsFelipe.financeiro.service.AccountService;
import mrcsFelipe.financeiro.service.FinancialReleaseService;
import mrcsFelipe.financeiro.service.UserService;
import mrcsFelipe.financeiro.vo.AccountsListVO;
import mrcsFelipe.financeiro.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@Autowired
	private UserRepository repository;
	
	
	/******
	 * 
	 * 
	 * Um area de teste aqui =] 
	 * 
	 * 
	 */
	

	//	GET DO JSON SERVICO 
	
	@RequestMapping(value="/view/teste/angularJson", 
					method=RequestMethod.GET, 
					produces="application/json")
	public @ResponseBody List<User> topicosUsuarioJson(){
		
		//List<User> lstUser = userService.findAll();
		List<User> lstUser = repository.findAllMoreAccount();
		
		List<UserVO> lstUserVO = new ArrayList<UserVO>();
		
		for (User user : lstUser) {
			
			UserVO userVO = new UserVO();
			userVO.setId(user.getId());
			userVO.setEmail(user.getEmail());
			userVO.setEnable(user.isEnabled());
			userVO.setName(user.getName());
			lstUserVO.add(userVO);
		}
		
		List<Account> accounts = accountService.findAll("marcos@gmail.com");
		AccountsListVO accountsVO = new AccountsListVO(0, 0, accounts);
		
		
		System.out.println("OIEE");
		return lstUser;
	}
	
	
	
	// POST PARA CREATER COM JSON -- SERVICO 
	
	@RequestMapping(value="/services/accounts/", method=RequestMethod.POST, produces ="application/json")
	public ResponseEntity<?> createUser(@ModelAttribute("user")UserVO user){
		try {
			System.out.println(user.getName());
			return new ResponseEntity<User>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
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
        	
        
        	
        	List<Account> accounts =  accountService.findAll(auth.getName());
    		List<FinancialRelease> releases =  financialReleaseService.findAllReleaseByUser(auth.getName());
    		
    		
    		//Getting total em cada Account -- Total dos lançamentos + do start da conta
    		for(int i = 0 ; i < accounts.size() ; i++){
    			Integer id = accounts.get(i).getId();
    			BigDecimal total =  accountService.totalInAccount(id);
    			if(total == null){
    				total = accounts.get(i).getAmountStart();
    			}
    			accounts.get(i).setTotal(total);
    		}
    		
    		//Getting Total Amount Start
    		BigDecimal totalAmountStartAllAccount =  accountService.amountStartTotalAllAccount( auth.getName());
    		
    		//Getting Everytotal Amount + Release 
    		BigDecimal totalAllAccountAndRelease =  accountService.totalAllAccountAndRelease( auth.getName());
    		
    		//Total Release for User
    		BigDecimal totalReleaseByUser =  financialReleaseService.totalReleaseByUser( auth.getName());
    		
    		//Getting User
    		User user =  userService.findByEmail( auth.getName());
    		
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
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user  = userService.findByEmail( auth.getName());
		
		ModelAndView mav = new ModelAndView("user/accounts");
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("lstAccount", accountService.findAll( auth.getName()));
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView view = new ModelAndView("user/createRelease");
		
		Map<String, Object> modelView = new HashMap<String, Object>();
		modelView.put("accounts", accountService.findAll( auth.getName()));		
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user =  userService.findByEmail( auth.getName());
		
		ModelAndView view = new ModelAndView("user/perfil");
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("user", user);
		view.addAllObjects(maps);
		return view;
	}
	
}
