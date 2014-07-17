package mrcsFelipe.financeiro.service;

import java.util.List;

import mrcsFelipe.financeiro.entity.FinancialRelease;
import mrcsFelipe.financeiro.repository.FinancialReleaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
	
}
