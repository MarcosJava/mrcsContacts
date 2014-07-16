package mrcsFelipe.financeiro.repository;

import java.util.List;

import mrcsFelipe.financeiro.entity.Account;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends CrudRepository<Account, Integer> , PagingAndSortingRepository<Account, Integer>{
	
	public Account findById(Integer id);
	
	@Modifying
	@Query("SELECT a FROM Account a, User u WHERE a.user.id = u.id AND u.id = :id")
	public List<Account> findAccountByUser(@Param("id")Integer idUser);
	
	
}
