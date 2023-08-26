package com.shopacc.service.imp;

import javax.inject.Inject;

import com.shopacc.dao.IUserDAO;
import com.shopacc.model.UserModel;
import com.shopacc.service.IUserService;

public class UserService implements IUserService{

	@Inject
	private IUserDAO userDAO;
	
	@Override
	public UserModel findByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return userDAO.findByUserNameAndPassword(userName, password);
	}

	@Override
	public UserModel save(UserModel userModel) {
		// TODO Auto-generated method stub
		int newId = userDAO.save(userModel);
		return userDAO.findOne(newId);
	}

}
