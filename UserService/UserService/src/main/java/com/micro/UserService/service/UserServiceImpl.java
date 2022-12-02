package com.micro.UserService.service;

import com.micro.UserService.exception.ResourceNotFoundException;
import com.micro.UserService.model.Rating;
import com.micro.UserService.model.User;
import com.micro.UserService.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public User getUser(String userid) throws ResourceNotFoundException {
        Optional<User> user =  userDao.findById(userid);

        if(user.isPresent()){
            return user.get();

        }else
            throw new ResourceNotFoundException("User is not found from server with given Id: " + userid);
    }
}
