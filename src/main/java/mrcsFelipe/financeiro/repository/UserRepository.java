package mrcsFelipe.financeiro.repository;

import java.util.List;

import mrcsFelipe.financeiro.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	
    User findByEmail(String email);
    
    User findByEmailAndPassword(String email, String password);
    
    @Query("SELECT DISTINCT(d) FROM User d LEFT JOIN FETCH d.account")
    List<User> findAllMoreAccount();
    
}
