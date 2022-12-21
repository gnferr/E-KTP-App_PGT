package com.guranyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guranyu.model.UserModel;
import com.guranyu.repository.IUserRepository;
import com.guranyu.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserRepository userRepository;
	
	@Override
	public UserModel insertUser(UserModel user) {
		// TODO Auto-generated method stub
		return userRepository.insertUser(user);
	}

	@Override
	public List<UserModel> getAll() {
		// TODO Auto-generated method stub
		return userRepository.getAll();
	}

	@Override
	public UserModel userLogin(String email,String password) {
		// TODO Auto-generated method stub
		return userRepository.userLogin(email, password);
	}


}
