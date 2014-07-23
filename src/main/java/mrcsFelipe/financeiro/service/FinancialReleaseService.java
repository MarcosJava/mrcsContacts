package mrcsFelipe.financeiro.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import mrcsFelipe.financeiro.entity.FinancialRelease;
import mrcsFelipe.financeiro.repository.FinancialReleaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class FinancialReleaseService {

	@Autowired
	private FinancialReleaseRepository financialReleaseRepository;
	
	public List<FinancialRelease> findAllReleaseByUser(Integer idUser){
		return financialReleaseRepository.findAllReleaseByUser(idUser);
	}
	
	public void save(FinancialRelease release){
		this.financialReleaseRepository.save(release);
	}
	
	public List<FinancialRelease> findAllReleaseForLimit(String email, int limit){
		return financialReleaseRepository.findAllReleaseForLimit(email, new PageRequest(0, limit));
	}
	
	public void deleteById(Integer id){
		financialReleaseRepository.delete(id);
	}
	
	public List<FinancialRelease> maxRelease(String email){
		return financialReleaseRepository.greatRelease(email);
	}
	
	public List<FinancialRelease> minRelease(String email){
		return financialReleaseRepository.minRelease(email);
	}
	
	public List<FinancialRelease> findAllReleaseBetweenDate(Date one, Date two, String email){
		return financialReleaseRepository.findAllReleaseBetweenDate(one, two, email);
	}
	
	public BigDecimal findTotalBetweenDate(Date one, Date two, String email){
		return financialReleaseRepository.findTotalBetweenDate(one, two, email);
	}
	
	public BigDecimal totalReleaseByUser(String email){
		return this.financialReleaseRepository.totalReleaseByUserAndAccount(email);
	}

}
