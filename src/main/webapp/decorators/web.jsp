<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="icon" type="image/x-icon" href="<c:url value= 'template/web/img/favicon.ico'/>"/>
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="<c:url value= '/template/web/css/styles.css'/>" rel="stylesheet" />
     <link href="<c:url value='/template/web/css/index.css'/>" rel="stylesheet" />
    <link href="<c:url value='/template/web/css/shop.css'/>" rel="stylesheet" />
    <link href="<c:url value='/template/web/css/cart.css'/>" rel="stylesheet" />
    <link href="<c:url value='/template/web/css/detail.css'/>" rel="stylesheet" />
    <link href="<c:url value='/template/web/css/input_account.css'/>" rel="stylesheet" />
    
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.js'/>" ></script>
    
</head>
<body>
	<div class="top-scroll">
        <a href="#"><i class="bi bi-arrow-up-circle-fill"></i></a>
    </div>
	<!-- header -->
	<%@ include file="/common/web/header.jsp" %>
	<!-- header -->
	
	<!-- body -->
	<decorator:body/>
	<!-- body -->

	<!-- footer -->
	<%@ include file="/common/web/footer.jsp" %>
	<!-- footer -->
		
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="<c:url value= 'template/web/js/scripts.js'/>"></script>
    <script src="<c:url value='/template/web/js/shop.js'/>"></script>
    
</body>
</html>