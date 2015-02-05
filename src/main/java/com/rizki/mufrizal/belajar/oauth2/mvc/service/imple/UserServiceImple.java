package com.rizki.mufrizal.belajar.oauth2.mvc.service.imple;

import com.rizki.mufrizal.belajar.oauth2.mvc.domain.User;
import com.rizki.mufrizal.belajar.oauth2.mvc.domain.UserRole;
import com.rizki.mufrizal.belajar.oauth2.mvc.repository.UserRepository;
import com.rizki.mufrizal.belajar.oauth2.mvc.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by rizki on 05/02/15.
 */

@Service
@Transactional(readOnly = true)
public class UserServiceImple implements UserService {
    
    @Resource
    private UserRepository userRepository;
    
    @Transactional(readOnly = false)
    @Override
    public void save(User user) {
        
        //Hash password
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        Set<UserRole> userRoles = new HashSet<UserRole>();
        userRoles.add(userRole);
        user.setUserRoles(userRoles);

        userRepository.save(user);
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
