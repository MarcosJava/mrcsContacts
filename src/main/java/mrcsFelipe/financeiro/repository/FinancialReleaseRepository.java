package mrcsFelipe.financeiro.repository;

import java.util.List;

import mrcsFelipe.financeiro.entity.FinancialRelease;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface FinancialReleaseRepository extends 
				 CrudRepository<FinancialRelease, Integer>,
				 PagingAndSortingRepository<FinancialRelease, Integer>{

	
	@Modifying
	@Query("SELECT fr FROM FinancialRelease fr, User u WHERE fr.user.id = u.id AND u.id = :id")
	public List<FinancialRelease> findAllReleaseByUser(@Param("id")Integer idUser);
	
	
	@Query("SELECT fr FROM FinancialRelease fr, User u "+
		   "WHERE fr.user.id = u.id AND u.email=:email " + 
		   "ORDER BY fr.id DESC")
	public List<FinancialRelease> findAllReleaseForLimit(@Param("email")String email, 
														Pageable pageable);
	
	@Query("FROM FinancialRelease "
			+ "WHERE value=(select max(f.value) from FinancialRelease f WHERE f.user.email=:email) ")
	public FinancialRelease greatRelease(@Param("email") String email);
	
	
	@Query("FROM FinancialRelease "
			+ "WHERE value=(select min(f.value) from FinancialRelease f WHERE f.user.email=:email) ")
	public FinancialRelease minRelease(@Param("email") String email);
	
	
	
}
