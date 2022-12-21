package com.guranyu.service;

import java.util.List;

import com.guranyu.model.UserModel;

public interface IUserService {
	public UserModel insertUser(UserModel user);
	public List<UserModel> getAll();
	public UserModel userLogin(String email,String password);
}
