package com.shopacc.service;

import com.shopacc.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPassword(String userName, String password);
	UserModel save(UserModel userModel);
}
