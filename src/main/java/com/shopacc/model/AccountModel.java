package com.shopacc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountModel {
	
	
	private int id;
	private String img;
	private java.math.BigDecimal price;
	private int numCharacter;
	private int numSkin;
	private String rank;
	private Integer page;
	private Integer maxPageItem;
	private Integer totalPage;
	private Integer totalItem;
	private List<AccountModel> listResult = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public java.math.BigDecimal getPrice() {
		return price;
	}
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	public int getNumCharacter() {
		return numCharacter;
	}
	public void setNumCharacter(int numCharacter) {
		this.numCharacter = numCharacter;
	}
	public int getNumSkin() {
		return numSkin;
	}
	public void setNumSkin(int numSkin) {
		this.numSkin = numSkin;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getMaxPageItem() {
		return maxPageItem;
	}
	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}
	public List<AccountModel> getListResult() {
		return listResult;
	}
	public void setListResult(List<AccountModel> listResult) {
		this.listResult = listResult;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountModel other = (AccountModel) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "AccountModel [id=" + id + ", img=" + img + ", price=" + price + ", numCharacter=" + numCharacter
				+ ", numSkin=" + numSkin + ", rank=" + rank + ", page=" + page + ", maxPageItem=" + maxPageItem
				+ ", totalPage=" + totalPage + ", totalItem=" + totalItem + ", listResult=" + listResult + "]";
	}

}
