package mrcsFelipe.financeiro.service;

import java.math.BigDecimal;
import java.util.List;

import mrcsFelipe.financeiro.entity.Account;
import mrcsFelipe.financeiro.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	
	public void save(Account account){
		accountRepository.save(account);
	}
	
	public List<Account> findAll(Integer idUser){
		return accountRepository.findAccountByUser(idUser);
	}
	
	public Account findById(Integer id){
		return accountRepository.findById(id);
	}
	
	public void delete(Account account){
		accountRepository.delete(account);
	}
	
	public void update(Account account){
		accountRepository.save(account);
	}
	
	public BigDecimal totalInAccount(Integer idAccount){
		return accountRepository.valueTotalAccount(idAccount);
	}
	
	public BigDecimal amountStartTotalAllAccount(String email){
		return this.accountRepository.amountStartTotalAllAccount(email);
	}
	
}
