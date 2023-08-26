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

@WebServlet(urlPatterns = {"/addToCart"})
public class AddToCartController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IAccountService accountService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idP = Integer.parseInt( req.getParameter("idP"));
		HttpSession session = req.getSession();
		List<AccountModel> accList =  ((AccountModel)session.getAttribute("model")).getListResult();
		
		AccountModel accountModel = accountService.findOne(idP);
		
		List<Cart> listCart = null;
		
		if(accountModel != null) {
			if(session.getAttribute("cart") == null) {
				// chưa có giỏ hàng trong session => tạo mới
				listCart = new ArrayList<Cart>();
				
			}
			else { // đã có giỏ hàng => lấy ra để sử lý
				listCart = (List<Cart>) session.getAttribute("cart");
				
			}
			
			// Kiểm tra xem sản phẩm được thêm vào có trong giỏ hàng chưa 
			// nếu tồn tại => thì bỏ qua
			boolean isExists = false;
			
			for (Cart cart : listCart) {
				if(cart.getAccountModel().getId() == idP) {
					// đã tồn tại
					isExists = true;
					break;
				}
			}
			
		
			// nếu chưa tồn tại => thêm mới
			if(!isExists) {				
				Cart cart = new Cart();
				cart.setAccountModel(accountModel);
				// lưu database và lấy cái key vừa tạo của cart
//				int cartIdNew = CartDAO.insert(cart);
				
				
//				cart.setId(cartIdNew);
				listCart.add(cart);
			}
			
			session.setAttribute("cart", listCart);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/view/web/shop.jsp");
		rd.forward(req, resp);
		
	}
}
