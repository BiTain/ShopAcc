package com.shopacc.service.imp;

import javax.inject.Inject;

import com.shopacc.dao.IPayDAO;
import com.shopacc.model.PayModel;
import com.shopacc.service.IPayService;

public class PayService implements IPayService{

	@Inject
	private IPayDAO payDao;
	@Override
	public void save(PayModel payModel) {
		// TODO Auto-generated method stub
		payDao.save(payModel);
	}

}
