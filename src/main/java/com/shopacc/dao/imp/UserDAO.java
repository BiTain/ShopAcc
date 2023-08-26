package com.shopacc.dao.imp;

import java.util.List;

import com.shopacc.dao.IUserDAO;
import com.shopacc.mapper.UserMapper;
import com.shopacc.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findByUserNameAndPassword(String userName, String password) {
		StringBuilder sql = new StringBuilder("SELECT * FROM users ");
		sql.append(" WHERE username = ? AND password = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public int save(UserModel userModel) {
		StringBuilder sql = new StringBuilder("insert into users ");
		sql.append(" values (?,?,?,?)");
		return insert(sql.toString(), userModel.getFullName(),userModel.getUserName(),
				userModel.getPassWord(),userModel.getEmail());
	}

	@Override
	public UserModel findOne(int id) {
		String sql = "select * from users where id = ?";
		List<UserModel> users = query(sql,new UserMapper(), id);
		return users.isEmpty() ? null : users.get(0);
	}


}
