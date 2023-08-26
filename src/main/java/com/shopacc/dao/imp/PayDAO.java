package com.shopacc.dao.imp;

import com.shopacc.dao.IPayDAO;
import com.shopacc.model.PayModel;

public class PayDAO extends AbstractDAO<PayModel> implements IPayDAO{

	@Override
	public void save(PayModel payModel) {
		// TODO Auto-generated method stub
		String sql = "insert into pay values ( ?, ?)";
		update(sql, payModel.getIdUser(),payModel.getIdAccount());
	}
	
}
