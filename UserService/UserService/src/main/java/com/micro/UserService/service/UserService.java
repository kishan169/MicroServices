package com.micro.UserService.service;

import com.micro.UserService.exception.ResourceNotFoundException;
import com.micro.UserService.model.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public List<User> getAllUser();

    public User getUser(String userid) throws ResourceNotFoundException;
}
