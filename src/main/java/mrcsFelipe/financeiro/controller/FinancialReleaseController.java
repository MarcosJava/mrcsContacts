package mrcsFelipe.financeiro.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.PathVariable;
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
	
	private String message = "";
	
	
	/**
	 * 
	 *CREATE
	 */
	
	
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
		Map<String, Object> modelView = new HashMap<String, Object>();
		modelView.put("accounts", accountService.findAll(user.getId()));
		String drawOrDebit = "";
		
		
		//Validate
		if(idAccount.trim().equals("") || idAccount == null){
			System.err.println("Sem Conta");
			modelView.put("error", "Ocorreu algum erro, informe a sua Conta");
			view.setViewName("user/createRelease");
			view.addAllObjects(modelView);
			return view;
		}
		if(option.trim().equals("") || option == null){
			System.err.println("Sem Opcao");
			modelView.put("error", "Ocorreu algum erro, informe se é Receita ou Despesa");
			view.setViewName("user/createRelease");
			view.addAllObjects(modelView);
			return view;
		}
		if(value.trim().equals("") || value == null){
			System.err.println("Sem Valor");
			modelView.put("error", "Ocorreu algum erro, informe o valor a ser depositado");
			view.setViewName("user/createRelease");
			view.addAllObjects(modelView);
			return view;
		}
		if(date.trim().equals("") || date == null){
			System.err.println("Sem Data");
			modelView.put("error", "Ocorreu algum erro, informe a data do deposito");
			view.setViewName("user/createRelease");
			view.addAllObjects(modelView);
			return view;
		}

		
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
			financialRelease.setName(name);
			
			
			//Setting view with modelandView
			if(option.equals("revenue")){
				drawOrDebit = "acrescentado";
			} else if(option.equals("deposit")){
				drawOrDebit = "retirado";
			}
			
			this.financialReleaseService.save(financialRelease);
			
			modelView.put("success", "Sua conta " + account.getName() +
					" foi " + drawOrDebit + " o valor R$" + value);
			
			view.setViewName("user/createRelease");
			view.addAllObjects(modelView);
			
			return view;
		} catch (Exception e) {
			modelView.put("error", "Ocorreu algum erro, informe ao suporte no Contact me");
			
			view.setViewName("user/createRelease");
			view.addAllObjects(modelView);
			
			return view;
		}
		
	}
	
	/**
	 * 
	 *DELETE
	 */
	
	
	@RequestMapping("user/release/delete/{id}")
	public ModelAndView deleteRelease(@PathVariable("id")Integer id ){
		
		financialReleaseService.deleteById(id);
		this.message = "Lançamento deletado com Sucesso";
		return findAllForLimit5();
	}
	
	
	
	/**
	 * 
	 *Limit 5
	 */
	
	
	@RequestMapping("user/releases/limit/5")
	public ModelAndView findAllForLimit5(){
		try {
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			List<FinancialRelease> releases = 
					financialReleaseService.findAllReleaseForLimit(auth.getName().trim(),5);
			
		
			BigDecimal total = new BigDecimal(0);
			
			for (FinancialRelease financialRelease : releases) {
				total = total.add(financialRelease.getValue());	
				System.err.println("VALOR  == " + financialRelease.getValue());
				System.err.println("VALOR TOTAL BIG == " + total);
			}
			
			
			
			ModelAndView view = new ModelAndView("user/releases/limit5");
			Map<String, Object> maps = new HashMap<String, Object>();
			maps.put("lstRelease", releases);
			maps.put("total", total);
			maps.put("success", message);
			
			
			message = " ";
			
			view.addAllObjects(maps);
			return view;
			
		} catch (Exception e) {
			return null;
		}

	}
	
	
	/**
	 * 
	 * O maior lancamento
	 */
	
	@RequestMapping("user/releases/maximumRelease")
	public ModelAndView maximumRelease(){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		FinancialRelease release = this.financialReleaseService.maxRelease(auth.getName().trim());
		
		ModelAndView view = new ModelAndView();
		view.setViewName("user/releases/maximum");
		
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("release", release);
		
		view.addAllObjects(maps);
		
		return view;
	}
	
}
