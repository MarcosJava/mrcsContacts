package mrcsFelipe.financeiro.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import mrcsFelipe.financeiro.entity.Account;
import mrcsFelipe.financeiro.entity.User;
import mrcsFelipe.financeiro.service.AccountService;
import mrcsFelipe.financeiro.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	
	
	/**
	 * 
	 *CREATE
	 */
	
	@RequestMapping(value="user/createAccount/create",method={RequestMethod.POST, RequestMethod.PUT})
	public ModelAndView createAccount(@RequestParam("name")String name,
									  @RequestParam("description")String description,
									  @RequestParam("amount")String amount){
		
		
		
		ModelAndView mavError = new ModelAndView("user/createAccount");
		ModelAndView mavSuccess = new ModelAndView("user/accounts");
		
		
		
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
		modelMap.put("error", "Cadastrado com Sucesso : " + name);
		modelMap.put("lstAccount", accountService.findAll(user.getId()) );
		mavSuccess.addAllObjects(modelMap);
		
		System.out.println(name);
		
		return mavSuccess;
	}
	
	
	/**
	 * 
	 *UPDATE
	 */
	
	
	@RequestMapping(value="user/account/update",method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateAccountRetrieve(@Valid Account account,
											  BindingResult bindingResult,
											  String dateCreate){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user  = userService.findByEmail(auth.getName());
		
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
		ModelAndView view = new ModelAndView("user/accounts");
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			account.setUser(user);
			account.setDateCreate(sdf.parse(dateCreate));
			accountService.update(account);
			
			map.put("error", "Editado com Sucesso a Conta = " + account.getName());
			map.put("lstAccount", accountService.findAll(user.getId()));
			view.addAllObjects(map);
			
				
			return view;
			
		} catch (ParseException e) {
			
			e.printStackTrace();
			
			map.put("error", "Não foi possivel fazer essa alteração, caso o erro persista."
					+ "Informe ao suporte no Contact Me");
			map.put("lstAccount", accountService.findAll(user.getId()));
			view.addAllObjects(map);
			return view;
		}
		
	}
	
	@RequestMapping(value="user/accounts/update/{id}" , method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateAccount(@PathVariable("id")String id){
		
		ModelAndView modelAndView = new ModelAndView("user/accounts/update/account");
		Account account = accountService.findById(Integer.parseInt(id));
		
		
		Map<String, Object> model =	new HashMap<String, Object>();
		model.put("account", account);
		modelAndView.addAllObjects(model);
		
		return  modelAndView;
		
	}
	
	@RequestMapping(value="user/account/delete/{id}", method={RequestMethod.GET})
	public ModelAndView deleteAccount(@PathVariable("id")String id ){
		
		Map<String, Object> map = new HashMap<String, Object>();
		Account account = new Account();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user  = userService.findByEmail(auth.getName());
		
		ModelAndView view = new ModelAndView("user/accounts");
		
		
		account = accountService.findById(Integer.parseInt(id));
		
		accountService.delete(account);
		
		
		map.put("lstAccount", accountService.findAll(user.getId()));
		map.put("error", "Conta excluida com sucesso : " +  account.getName());
		view.addAllObjects(map);
		return view;
		
	}
	
	
	
	
	
}
