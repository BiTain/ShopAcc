<%@page import="com.shopacc.model.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.shopacc.model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-light bg-light"
	style="position: fixed; width: 100%; z-index: 99;">
	<%
							List<Cart> list = (List<Cart>) session.getAttribute("cart");
							
							int total = (list == null) ? 0 :  list.size();
						%>
	
	<div class="container px-4 px-lg-5">
		<a class="logo" href="#!"><img
			src="<c:url value='/template/web/img/BNVSHOP.VN.png'/>" alt=""
			style="width: 45px; height: 45px; transform: translateX(-30px)"></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item"><a class="nav-link"
					aria-current="page" href="<c:url value='trang-chu'/>">Trang chủ</a></li>
				<li class="nav-item"><a class="nav-link" href="#!">Nạp thẻ</a></li>
				<li class="nav-item "><a class="nav-link "
					href='<c:url value="/shop?page=1&maxPageItem=8"/>' role="button"
					aria-expanded="false">Shop</a></li>
				<li class="nav-item"><a class="nav-link hover-black" href="#!">Tin
						tức</a></li>
				<li class="nav-item"><a class="nav-link hover-black" href="<c:url value='/input_account'/>">Thêm Account</a></li>
			</ul>
			<a href="<c:url value='/cart'/>">
				<button class="btn btn-outline-dark" type="submit" >
					<i class="bi-cart-fill me-1"></i> Cart <span
						class="badge bg-dark text-white ms-1 rounded-pill">
						<%=total %>
						</span>
				</button>
			</a>

			<%
			UserModel us = (UserModel) session.getAttribute("userModel");
			if (us != null) {
			%>
			<a href="<c:url value='/logout'/>">
			<button class="btn btn-outline-dark" type="submit"
				style="margin-left: 10px;">
				<i class="bi bi-person-circle"></i> ${userModel.fullName} - <span
					style="color: red;">LogOut</span>
			</button>
			</a>
			<%
			} else {
			%>
			<a href="<c:url value='/login'/>">
				<button class="btn btn-outline-dark" type="submit"
					style="margin-left: 10px;">
					<i class="bi bi-person-circle"></i> Login
				</button>
			</a>
			<%
			}
			%>


		</div>
	</div>
</nav>