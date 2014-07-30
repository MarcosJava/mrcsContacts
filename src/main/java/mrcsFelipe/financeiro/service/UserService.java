package mrcsFelipe.financeiro.service;

import java.util.List;

import mrcsFelipe.financeiro.entity.User;
import mrcsFelipe.financeiro.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    
    public void save(User user){
    	userRepository.save(user);
    }
    public void delete(User user){
    	userRepository.delete(user);
    }
    public List<User> findAll(){
    	return (List<User>) this.userRepository.findAll();
    }
    
    
}
