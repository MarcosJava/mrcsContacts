package mrcsFelipe.financeiro.repository;

import mrcsFelipe.financeiro.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}
