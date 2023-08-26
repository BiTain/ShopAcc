package com.shopacc.service.imp;

import java.util.List;

import javax.inject.Inject;

import com.shopacc.dao.IAccountDAO;
import com.shopacc.model.AccountModel;
import com.shopacc.service.IAccountService;

public class AccountService implements IAccountService{

	@Inject
	private IAccountDAO accountDAO;
	@Override
	public List<AccountModel> findAll(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return accountDAO.findAll(offset, limit);
	}
	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return accountDAO.getTotalItem();
	}
	@Override
	public AccountModel findOne(int id) {
		// TODO Auto-generated method stub
		return accountDAO.findOne(id);
	}
	@Override
	public AccountModel save(AccountModel accountModel) {
		// TODO Auto-generated method stub
		int accountId = accountDAO.save(accountModel);
		return accountDAO.findOne(accountId);
	}
	@Override
	public void delete(int[] ids) {
		// TODO Auto-generated method stub
		for (int id : ids) {
			accountDAO.delete(id);
		}
		
	}
	

}
