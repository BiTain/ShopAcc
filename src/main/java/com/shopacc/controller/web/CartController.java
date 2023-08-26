package com.shopacc.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("userModel")!=null) {
			RequestDispatcher rd = req.getRequestDispatcher("/view/web/cart.jsp");
			rd.forward(req, resp);
		}else {
			session.setAttribute("login_cart", "successfull");
			resp.sendRedirect("login");
		}
	}
}
