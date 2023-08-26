package com.shopacc.dao;

import java.util.List;

import com.shopacc.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel>{
	UserModel findByUserNameAndPassword(String userName, String password);
	int save(UserModel userModel);
	UserModel findOne(int id);
}
