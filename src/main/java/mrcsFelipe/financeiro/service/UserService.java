package mrcsFelipe.financeiro.service;

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
}
