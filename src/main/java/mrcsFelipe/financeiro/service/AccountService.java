package mrcsFelipe.financeiro.service;

import java.util.List;

import mrcsFelipe.financeiro.entity.Account;
import mrcsFelipe.financeiro.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public void save(Account account){
		accountRepository.save(account);
	}
	
	public List<Account> findAll(){
		return (List<Account>) accountRepository.findAll();
	}
	
	public Account findById(Integer id){
		return accountRepository.findById(id);
	}
}
