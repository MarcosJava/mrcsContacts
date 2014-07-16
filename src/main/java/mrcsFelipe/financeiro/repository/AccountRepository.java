package mrcsFelipe.financeiro.repository;

import mrcsFelipe.financeiro.entity.Account;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
	
	Account findById(Integer id); 

}
