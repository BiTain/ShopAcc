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

import com.shopacc.model.UserModel;
import com.shopacc.service.IUserService;
import com.shopacc.utils.FormUtil;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IUserService userService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("/view/login.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		UserModel userModel = FormUtil.toModel(UserModel.class, req);
		userModel = userService.save(userModel);
		if(userModel != null) {
			RequestDispatcher rd = req.getRequestDispatcher("/view/login.jsp");
			rd.forward(req, resp);
		}else {
			System.out.println("thất bại");
		}
	}

}
