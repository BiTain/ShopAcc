package com.shopacc.service;

import java.util.List;

import com.shopacc.model.AccountModel;

public interface IAccountService {
	List<AccountModel> findAll(Integer offset, Integer limit);
	int getTotalItem();
	AccountModel findOne(int id);
	AccountModel save(AccountModel accountModel);
	void delete(int[] ids);
}
