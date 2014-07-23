package mrcsFelipe.financeiro.repository;

import java.math.BigDecimal;
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
	
	@Query("SELECT (SUM(f.value) + a.amountStart) FROM FinancialRelease f, Account a, User u"
			+ " WHERE f.account.id = a.id "
			+ " AND f.user.id = u.id "
			+ " AND a.user.id= u.id"
			+ " AND a.id=:idAccount")
	public BigDecimal valueTotalAccount(@Param("idAccount")Integer idAccount);
	
	@Query("SELECT SUM(a.amountStart) FROM Account a WHERE a.user.email=:email")
	public BigDecimal amountStartTotalAllAccount(@Param("email")String email);
	
	@Query("SELECT SUM(f.value) + SUM(a.amountStart) FROM Account a, FinancialRelease f, User u"
			+ " WHERE f.user.id = u.id"
			+ " AND a.user.id = u.id"
			+ " AND f.account.id = a.id"
			+ " AND u.email=:email")
	public BigDecimal totalAllAccountAndRelease(@Param("email")String email);
	
}
