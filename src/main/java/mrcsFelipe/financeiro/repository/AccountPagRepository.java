package mrcsFelipe.financeiro.repository;

import mrcsFelipe.financeiro.entity.Account;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountPagRepository extends PagingAndSortingRepository<Account, Integer> {

	Page<Account> findByNameLike(Pageable pageable, String name);
}
