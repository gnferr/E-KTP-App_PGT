package com.guranyu.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.guranyu.model.UserModel;
import com.guranyu.repository.IUserRepository;

@Repository
public class UserRepository implements IUserRepository{

	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Override
	public UserModel insertUser(UserModel user) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_user(email,nama,password) VALUES(?,?,?)";
		jdbctemplate.update(query , new Object[] {user.getEmail(),user.getNama(),user.getPassword()});
		return user;
	}

	@Override
	public List<UserModel> getAll() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_user";
		return jdbctemplate.query(query, new BeanPropertyRowMapper<>(UserModel.class));
	}


	@Override
	public UserModel userLogin(String email,String password) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_user WHERE email = ? AND password = ?";
		return jdbctemplate.queryForObject(query,new BeanPropertyRowMapper<>(UserModel.class),email,password);
	}


}
