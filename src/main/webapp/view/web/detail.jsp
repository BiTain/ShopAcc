<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main style="padding-bottom: 20px;">
        <div class="container">
            <img src="<c:url value='/template/web/img/detail.jpg'/>" alt="" width="50%" >
            <div class="id-account">
                <h4>Mã tài khoản</h4>
                <span>${detailAccount.id}</span>
            </div>
            <div class="info-row">
                <div class="column-left">
                    <ul>
                        <li>Tướng: <b>${detailAccount.numCharacter}</b></li>
                        <li>Trang phục: <b>${detailAccount.numSkin}</b></li>
                    </ul>
                </div>
                <div class="column-right">
                    <ul>
                        <li>Rank: <b>${detailAccount.rank}</b></li>
                        <li>Liên kết Facebook: <b>Không</b></li>
                    </ul>
                </div>
            </div>
            <div class="price">
                <span class="priceScript"></span>
            </div>
            <div class="btn-pay-add">
                <div class="text-center">                                     
                    <a class="btn btn-outline-dark mt-auto" href="./shop.html"><i class="bi bi-arrow-90deg-left"></i> Back to shop</a>
                </div>
                <div class="text-center">                                    
                    <a class="btn btn-outline-dark mt-auto" href="#"><i class="bi bi-cart"></i> Add to cart</a>
                </div>
            </div>
        </div>
    </main>
    <script type="text/javascript">
    	var x = ${detailAccount.price}
    	x = x.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
    	console.log(x);
    	
    	var elementPrice = document.querySelector(".priceScript")
    	console.log(elementPrice)
    	elementPrice.innerText = x
    </script>
</body>
</html>