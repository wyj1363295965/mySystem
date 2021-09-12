package com.tik.mysystem.system.service;


import com.tik.mysystem.security.entity.LoginUser;
import com.tik.mysystem.system.entity.User;
import com.tik.mysystem.system.enums.UserStatus;
import com.tik.mysystem.system.exception.UserNameAlreadyExistException;
import com.tik.mysystem.system.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author shuang.kou
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void saveUser(LoginUser loginUser) {
        Optional<User> optionalUser = userRepository.findByUsername(loginUser.getUsername());
        if (optionalUser.isPresent()) {
            throw new UserNameAlreadyExistException("MybatisUser name already exist!Please choose another user name.");
        }
        User user = new User();
        user.setUsername(loginUser.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(loginUser.getPassword()));
        user.setRoles("DEV,PM,ADMIN");
        user.setStatus(UserStatus.CAN_USE);
        userRepository.save(user);
    }


    public boolean login(LoginUser loginUser) {
        User user=new User();
        user.setUsername(loginUser.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(loginUser.getPassword()));
        Optional<User> optionalUser = userRepository.findUserByNameAndPwd(
                user.getUsername(),
                bCryptPasswordEncoder.encode(user.getPassword()));

        if (optionalUser.isPresent()) {
            return true;
        }
        return false;
    }

    public User findUserByUserName(String name) {
        return userRepository.findByUsername(name)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with username " + name));
    }

    public void deleteUserByUserName(String name) {
        userRepository.deleteByUsername(name);
    }


    public Page<User> getAllUser(int pageNum, int pageSize) {
        return userRepository.findAll(PageRequest.of(pageNum, pageSize));
    }
}
