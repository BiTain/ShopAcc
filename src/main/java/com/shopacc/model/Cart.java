package com.shopacc.model;

import java.math.BigDecimal;

public class Cart {
	private int id;
	private AccountModel accountModel;
	private BigDecimal total;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AccountModel getAccountModel() {
		return accountModel;
	}
	public void setAccountModel(AccountModel accountModel) {
		this.accountModel = accountModel;
	}

	@Override
	public boolean equals(Object obj) {
		int i = (int) obj;
		return accountModel.getId() == i;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
}
