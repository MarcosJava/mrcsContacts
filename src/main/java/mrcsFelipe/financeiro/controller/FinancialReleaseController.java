package mrcsFelipe.financeiro.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

@Scope("request")
@Controller
public class FinancialReleaseController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FinancialReleaseService financialReleaseService;
	
	@RequestMapping(value="user/createRelease/create", method={RequestMethod.POST})
	public ModelAndView createRelease(String name,
									  String idAccount,
									  String description,
									  String option,
									  String value,
									  String date){
		
		//Getting User
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user  = userService.findByEmail(auth.getName());
		
		ModelAndView view = new ModelAndView();
		String drawOrDebit = "";
		
		
		//Validate
		// idAccount, option, value, date
		
		try {
			//Format Date
			DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date date2 = (Date) sdf.parse(date);
			
			
			
			//Getting Account
			Account account = accountService.findById(Integer.parseInt(idAccount));
			
			//Value for BigDecimal
			String valuePart = value.replace(".", "");
			valuePart = valuePart.replace(",", ".");
			String moreOrLess = "";
			
			if(option.equals("revenue")){
				moreOrLess = "";
			} else if(option.equals("deposit")){
				moreOrLess = "-";
			}
			valuePart = moreOrLess + valuePart;
			BigDecimal big = new BigDecimal(valuePart);
			
			
			//Complete Financial Release for persist
			FinancialRelease financialRelease = new FinancialRelease();
			financialRelease.setAccount(account);
			financialRelease.setUser(user);
			financialRelease.setDateRelease(date2);
			financialRelease.setValue(big);
			financialRelease.setDescription(description);
			financialRelease.setTypeValue(option);
			
			
			//Setting view with modelandView
			if(option.equals("revenue")){
				drawOrDebit = "acrescentado";
			} else if(option.equals("deposit")){
				drawOrDebit = "retirado";
			}
			
			this.financialReleaseService.save(financialRelease);
			
			Map<String, Object> modelView = new HashMap<String, Object>();
			modelView.put("accounts", accountService.findAll(user.getId()));
			modelView.put("success", "Sua conta " + account.getName() +
					" foi " + drawOrDebit + " o valor " + value);
			
			view.setViewName("user/createRelease");
			view.addAllObjects(modelView);
			
			return view;
		} catch (Exception e) {
			Map<String, Object> modelView = new HashMap<String, Object>();
			modelView.put("accounts", accountService.findAll(user.getId()));
			modelView.put("error", "Ocorreu algum erro, informe ao suporte no Contact me");
			
			view.setViewName("user/createRelease");
			view.addAllObjects(modelView);
			
			return view;
		}
		
	}
	
	
}
