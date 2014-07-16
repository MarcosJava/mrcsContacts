package mrcsFelipe.financeiro.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import mrcsFelipe.financeiro.entity.Account;
import mrcsFelipe.financeiro.entity.User;
import mrcsFelipe.financeiro.service.AccountService;
import mrcsFelipe.financeiro.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@Value("5")
	private int maxResult;
	
	@RequestMapping("user/createAccount/create")
	public ModelAndView createAccount(@RequestParam("name")String name,
									  @RequestParam("description")String description,
									  @RequestParam("amount")String amount){
		
		ModelAndView mavError = new ModelAndView("protected/user/createAccount");
		ModelAndView mavSuccess = new ModelAndView("protected/user/accounts");
		
		
		
		if(name.trim().equals("") || name == null){
			mavError.addObject("error", "Coloque o nome da conta");
		}
		
		if(amount.trim().equals("")){
			amount = "0";
		}
		
		User user = new User();
		Account account = new Account();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		user = userService.findByEmail(auth.getName());
		account.setUser(user);
		account.setDateCreate(new Date());
		account.setAmountStart(new BigDecimal(amount));
		account.setDescription(description);
		account.setName(name);
		account.setFavorite(false);
		accountService.save(account);

		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("error", "Cadastrado com Sucesso");
		modelMap.put("lstAccount", accountService.findAll() );
		mavSuccess.addAllObjects(modelMap);
		
		return mavSuccess;
	}
	
	
	@RequestMapping(value="user/accounts/update/{id}" , method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateAccount(@PathVariable("id")String id){
		
		ModelAndView modelAndView = new ModelAndView("protected/user/accounts/update/account");
		Account account = accountService.findById(Integer.parseInt(id));
		
		
		Map<String, Object> model =	new HashMap<String, Object>();
		model.put("account", account);
		modelAndView.addAllObjects(model);
		
		return  modelAndView;
		
	}
	
	@RequestMapping(value="user/account/delete/{id}", method={RequestMethod.GET})
	public ModelAndView deleteAccount(@PathVariable("id")String id ){
		
		ModelAndView view = new ModelAndView("protected/user/accounts");
		
		System.out.println(id);
		return view;
		
	}
	
	
	
}
