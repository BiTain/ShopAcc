package com.shopacc.dao;

import java.util.List;

import com.shopacc.model.AccountModel;
import com.shopacc.model.UserModel;

public interface IAccountDAO extends GenericDAO<AccountModel>{
	List<AccountModel> findAll(Integer offset, Integer limit);
	int getTotalItem();
	AccountModel findOne(int id);
	int save(AccountModel accountModel);
	void delete(int id);
}
