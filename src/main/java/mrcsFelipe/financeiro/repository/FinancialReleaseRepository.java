package mrcsFelipe.financeiro.repository;

import java.util.List;

import mrcsFelipe.financeiro.entity.FinancialRelease;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FinancialReleaseRepository extends CrudRepository<FinancialRelease, Integer> {

	
	@Modifying
	@Query("SELECT fr FROM FinancialRelease fr, User u WHERE fr.user.id = u.id AND u.id = :id")
	public List<FinancialRelease> findAllReleaseByUser(@Param("id")Integer idUser);
	
}
