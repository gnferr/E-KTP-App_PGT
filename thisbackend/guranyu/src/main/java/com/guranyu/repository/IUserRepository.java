package com.guranyu.repository;

import java.util.List;

import com.guranyu.model.UserModel;

public interface IUserRepository {
	public UserModel insertUser(UserModel user);
	public List<UserModel> getAll();
	public UserModel userLogin(String email,String password);
}
