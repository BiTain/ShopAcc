<%@page import="java.math.BigDecimal"%>
<%@page import="com.shopacc.model.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main style="margin-bottom: 200px;">
		<div class="container">
			<table >
				<thead>
					<tr style="text-align: center;">
						<th>Thông tin tài
							khoản</th>
						<th >Giá</th>
						<th >Tùy chọn</th>
					</tr>
				</thead>
				<tbody>
				
				<%
					List<Cart> carts = (List<Cart>) session.getAttribute("cart");
				BigDecimal total = new BigDecimal("0");
				if(carts!=null){
					for(Cart cart : carts) {
						total = total.add(cart.getAccountModel().getPrice());
					}}
				%>
			
				<c:forEach items="${cart}" var="item" >
					<tr> 
						<td>
							<ul>
								<li>Mã tài khoản: <b>${item.accountModel.id }</b></li>
								<li>Tướng: <b>${item.accountModel.numCharacter }</b></li>
								<li>Trang phục: <b>${item.accountModel.numSkin }</b></li>
								<li>Rank: <b>${item.accountModel.rank }</b></li>
							</ul>
						</td>
						<td><b class="red elementPrice"></b></td>
						<td>
							<div class="text-center detail">
								<a class="btn mt-auto" href="<c:url value="detail?id=${item.accountModel.id}"/>">Detail</a>
							</div>
							<div class="text-center delete">
								<a class="btn mt-auto" href="<c:url value="deleteCartItem?cartId=${item.accountModel.id}"/>">Detele</a>
							</div>
						</td>
					</tr>
					
					<script type="text/javascript">
								var x = ${item.accountModel.price}
								x = x.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
						    	var elementPrices = document.querySelectorAll(".elementPrice")
						    	
						    	elementPrices[elementPrices.length - 1].innerText = x
					</script>
					</c:forEach>
				</tbody>
			</table>
			<div class="payment-box" style="height: 220px;">
				<h2>Total</h2>
				<h4 style="position: relative; display: block;">
					<span class="red totalElement"><%=total %></span>
				</h4>
				<div class="text-center back">
					<a class="btn mt-auto" href="./shop.html">Back to shop</a>
				</div>
				<div class="text-center pay">
					<a class="btn mt-auto" href="#">Pay</a>
				</div>
			</div>
		</div>
	</main>
	<script type="text/javascript">
								var x = <%=total %>
								x = x.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
						    	var totalElement = document.querySelector(".totalElement")
						    	
						    	totalElement.innerText = x
					</script>
	

</body>
</html>