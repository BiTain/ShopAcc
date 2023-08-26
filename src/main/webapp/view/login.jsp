<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="icon" type="image/x-icon" href="<c:url value='/template/web/img/favicon.ico'/>" />
    <link href="<c:url value='/template/web/css/signIn_Up.css'/>" rel="stylesheet">
</head>
<body>
	<div class="container">
		<img src="<c:url value='/template/web/img/login.jpg'/>" alt="" id="imageId">
		<div class="signin-form">
			<form action="<c:url value='/login'/>" method="post">
				<span class="title-signin">Sign In</span> <label for="usernameId"
					class="lb-usn">USERNAME</label> <input type="text"
					placeholder="Username" name="userName" id="usernameId" size="52">
				<label for="passwordId" class="lb-pw">PASSWORD</label> <input
					type="password" placeholder="Password" name="passWord"
					id="passwordId" size="52">
				<div class="checkbox">
					<input type="checkbox" name="checkbox" id="checkboxId"> <label
						for="checkboxId" class="lb-rmb">Remember me</label> <a href="#"
						class="forgot-password">Forgot password?</a>
				</div>
				<button class="btn-signin">Sign In</button>
				<p class="para">
					Not a member? <span onclick="imgToRight()">Sign up</span>
				</p>
			</form>
		</div>
		<div class="signup-form">
			<form action="<c:url value='/register'/>" method="post">
				<span class="title-signup">Sign Up</span> <span class="fullName">NAME</span>
				<input type="text" name="fullName" id="firstNameId"
					placeholder="Full Name" size="52"> 
				<label for="emailId" class="lb-email">EMAIL</label> <input
					type="email" name="email" id="emailId" placeholder="Email"
					size="52"> <label for="usernameId" class="lb-usn">USERNAME</label>
				<input type="text" placeholder="Username" name="userName"
					id="usernameId" size="52"> <label for="passwordId"
					class="lb-pw">PASSWORD</label> <input type="password"
					placeholder="Password" name="passWord" id="passwordId" size="52">
				<label for="passwordId" class="lb-pw">CONFIRM PASSWORD</label> <input
					type="password" placeholder="Confirm Password" name="passwordconfirm"
					id="passwordId" size="52">
				<button class="btn-signup">Sign Up</button>
				<p class="para">
					Have an account? <span onclick="imgToLeft()">Sign in</span>
				</p>
			</form>
		</div>
	</div>
	 <script src="<c:url value='template/web/js/signIn_Up.js'/>"></script>
</body>
</html>
