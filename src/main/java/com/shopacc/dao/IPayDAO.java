package com.shopacc.dao;

import com.shopacc.model.PayModel;

public interface IPayDAO extends GenericDAO<PayModel>{
	void save(PayModel payModel);
}
