package mrcsFelipe.financeiro.service;

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
	
	@Autowired
	private FinancialReleaseRepository financialReleaseDao;
	
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
	
	public FinancialRelease maxRelease(String email){
		return financialReleaseRepository.greatRelease(email);
	}
	
	public FinancialRelease minRelease(String email){
		return financialReleaseRepository.minRelease(email);
	}
}
