package com.shopacc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopacc.model.AccountModel;

public class AccountMapper implements RowMapper<AccountModel>{

	@Override
	public AccountModel mapRow(ResultSet rs) {
		try {
			AccountModel accountModel = new AccountModel();
			accountModel.setId(rs.getInt("id"));
			accountModel.setImg(rs.getString("img"));
			accountModel.setPrice(rs.getBigDecimal("price"));
			accountModel.setNumCharacter(rs.getInt("numCharacter"));
			accountModel.setNumSkin(rs.getInt("numSkin"));
			accountModel.setRank(rs.getString("rank"));
			return accountModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
