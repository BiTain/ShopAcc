package com.shopacc.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopacc.model.AccountModel;
import com.shopacc.model.Cart;
import com.shopacc.service.IAccountService;

@WebServlet(urlPatterns = {"/deleteCartItem"})
public class DeleteCartItem extends HttpServlet{

	
	private static final long serialVersionUID = 1L;


	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int accId = Integer.parseInt( req.getParameter("cartId"));
				
		System.out.println(accId);
		
		HttpSession session = req.getSession();
		List<Cart> listCart = (List<Cart>) session.getAttribute("cart");
		
		for(int i = 0; i < listCart.size(); i++) {
			if(listCart.get(i).getAccountModel().getId() == accId) {
				listCart.remove(i);
				break;
			}
			
		}
		session.setAttribute("cart", listCart);
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/web/cart.jsp");
		rd.forward(req, resp);
		
	}
}
