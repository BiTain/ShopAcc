package com.shopacc.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopacc.model.AccountModel;
import com.shopacc.service.IAccountService;
import com.shopacc.service.imp.AccountService;
import com.shopacc.utils.FormUtil;
@WebServlet(urlPatterns = {"/shop"})
public class ShopController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IAccountService accountService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccountModel accountModel = FormUtil.toModel(AccountModel.class, req);
		Integer offset = (accountModel.getPage() - 1)*accountModel.getMaxPageItem();
		accountModel.setListResult(accountService.findAll(offset, accountModel.getMaxPageItem()));
		accountModel.setTotalItem(accountService.getTotalItem());
		accountModel.setTotalPage((int) Math.ceil((double) accountModel.getTotalItem() / accountModel.getMaxPageItem()) );
		HttpSession session = req.getSession();
		if(accountModel!=null) {
			session.setAttribute("model", accountModel);
			RequestDispatcher rd = req.getRequestDispatcher("/view/web/shop.jsp");
			rd.forward(req, resp);
		}
	}

}
