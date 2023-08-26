package com.shopacc.controller.web;

import java.io.IOException;
import java.math.BigDecimal;

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
import com.shopacc.utils.FormUtil;

@WebServlet(urlPatterns = {"/input_account"})
public class InputAccountController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IAccountService accountService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("/view/web/input_account.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		AccountModel accountModel = FormUtil.toModel(AccountModel.class, req);
		BigDecimal price = new BigDecimal(req.getParameter("price"));
		accountModel.setPrice(price);
		accountModel = accountService.save(accountModel);
		if(accountModel!=null) {
			RequestDispatcher rd = req.getRequestDispatcher("/view/web/home.jsp");
			rd.forward(req, resp);
		}else {
			System.out.println("fail");
		}
	}
}
