package com.shopacc.dao.imp;

import java.util.List;

import com.shopacc.dao.IAccountDAO;
import com.shopacc.mapper.AccountMapper;
import com.shopacc.mapper.UserMapper;
import com.shopacc.model.AccountModel;
import com.shopacc.model.UserModel;

public class AccountDAO extends AbstractDAO<AccountModel> implements IAccountDAO{

	@Override
	public List<AccountModel> findAll(Integer offset, Integer limit) {
		String sql = "select * from account order by id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		return query(sql,new AccountMapper(),offset,limit);
	}

	@Override
	public int getTotalItem() {
		String sql = "select count(*) from account";
		return count(sql);
	}

	@Override
	public AccountModel findOne(int id) {
		String sql = "select * from account where id = ?";
		List<AccountModel> accounts = query(sql,new AccountMapper(), id);
		return accounts.isEmpty() ? null : accounts.get(0);
	}

	@Override
	public int save(AccountModel accountModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("insert into account  ");
		sql.append(" values (?, ?, ?, ?, ?)");
		return insert(sql.toString(), accountModel.getImg(),accountModel.getPrice(),accountModel.getNumCharacter(),
					accountModel.getNumSkin(),accountModel.getRank());
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete account where id = ?";
		update(sql, id);
		
	}

}
