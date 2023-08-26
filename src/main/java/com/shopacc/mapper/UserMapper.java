package com.shopacc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopacc.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel userModel = new UserModel();
			userModel.setId(rs.getInt("id"));
			userModel.setUserName(rs.getString("userName"));
			userModel.setPassWord(rs.getString("passWord"));
			userModel.setFullName(rs.getString("fullName"));
			userModel.setEmail(rs.getString("email"));
			return userModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
