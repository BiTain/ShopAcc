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
	<main>
		<section class="py-5">
		<form action="<c:url value='/shop'/>" id="formSubmit"
			method="get">
			<div class="container px-4 px-lg-5 mt-5">
				<div class="filter">
					<span>BỘ LỌC TÌM KIẾM</span> <select name="soTuong" id="soTuongId">
						<option value="" disabled hidden selected="selected"
							class="defaultSelect">Số tướng</option>
						<option value="Dưới 50">Dưới 50</option>
						<option value="Từ 50 đến 80">Từ 50 đến 80</option>
						<option value="Trên 80">Trên 80</option>
					</select> <select name="soTrangPhuc" id="soTrangPhucId">
						<option value="" disabled hidden selected="selected"
							class="defaultSelect">Số trang phục</option>
						<option value="Dưới 100">Dưới 100</option>
						<option value="Từ 100 đến 200">Từ 100 đến 200</option>
						<option value="Trên 200">Trên 200</option>
					</select> <select name="hang" id="hangId">
						<option value="" disabled hidden selected="selected"
							class="defaultSelect">Bậc hạng</option>
						<option value="Đồng">Đồng</option>
						<option value="Bạc">Bạc</option>
						<option value="Vàng">Vàng</option>
						<option value="Bạch kim">Bạch kim</option>
						<option value="Kim cương">Kim cương</option>
						<option value="Tinh anh">Tinh anh</option>
						<option value="Cao thủ">Cao thủ</option>
						<option value="Chiến tướng">Chiến tướng</option>
						<option value="Thách đấu">Thách đấu</option>
					</select> <select name="giaTien" id="giaTienId">
						<option value="" disabled hidden selected="selected"
							class="defaultSelect">Giá tiền</option>
						<option value="Dưới 100.000 VND">Dưới 100.000 VND</option>
						<option value="Từ 100.000 VND đến 500.000 VND">Từ 100.000
							VND đến 500.000 VND</option>
						<option value="Từ 500.000 VND đến 1.000.000 VND">Từ
							500.000 VND đến 1.000.000 VND</option>
						<option value="Trên 1.000.000 VND">Trên 1.000.000 VND</option>
					</select> <i class="bi bi-funnel"></i>
					<button class="btn-filter">Lọc</button>
					<button class="btn-delete-filter" onclick="deleteFilter()">Xóa
						lọc</button>
				</div>
				<div class="row row-cols-xl-4 justify-content-center">
					<c:forEach var="item" items="${model.listResult}">
						<div class="card h-90" style="width:24% ; margin:5px 5px;" >
							<!-- Product image-->
							<img class="card-img-top" src="<c:url value='/template/web/img/${item.img}'/>"
								alt="..." />
							<!-- Product details-->
							<div class="card-body p-2">
								<div>
									<!-- Mục-->
									<ul>
										<li>Tướng: <b>${item.numCharacter}</b></li>
										<li>Trang phục: <b>${item.numSkin}</b></li>
										<li>Rank: <b>${item.rank}</b></li>
										<li >Giá: <b class="red priceScript"></b>
										</li>
									</ul>
									<!-- Số lượng đã bán-->
								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent" style="margin: auto;">
								<div class="text-center">
									<a class="btn btn-outline-dark mt-auto btnAddToCart"  href="<c:url value="/addToCart?idP=${item.id}"/>"
										onclick="addToCart()"><i class="bi bi-cart"></i> Add to
										cart</a>
								</div>
							</div>
						</div>
						<input type="hidden" value="${item.id}" name="idAccount" /> 
						<script type="text/javascript">
					    	var x = ${item.price}
					    	x = x.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
					    	console.log(x);
					    	
					    	var elementPrices = document.querySelectorAll(".priceScript")
					    	elementPrices[elementPrices.length - 1].innerText = x
					    </script>
					</c:forEach>
				</div>
			</div>
					<ul class="pagination" id="pagination" style="justify-content: center; margin-top: 10px"></ul>
					<input type="hidden" value="" id="page" name="page" /> 
					<input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
			</form>
		</section>
	</main>
	<script type="text/javascript">
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		var limit = 8;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage: currentPage,
				onPageClick : function(event, page) {
					if(currentPage != page){
					$('#maxPageItem').val(limit);
					$('#page').val(page);
					$('#formSubmit').submit();
					}
				}
			});
		});
	</script>
</body>
</html>