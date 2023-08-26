<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main>
		<div class="container">
			<h3 class="" style="text-align: center">THÔNG TIN TÀI KHOẢN</h3>
			<div class="form-container">
				<form action="input_account" method="post">
					<div class="num-character-skin-rank">
						<div class="num-character">
							<span>NUMBER OF CHARACTER</span> <input type="number"
								placeholder="Số lượng tướng" name="numCharacter" id="characterId"
								min="1" step="10">
						</div>
						<div class="num-skin">
							<span>NUMBER OF SKIN</span> <input type="number"
								placeholder="Số lượng trang phục" name="numSkin" id="skinId"
								min="0" step="10">
						</div>
						<div class="rank">
							<span>RANK</span> <select name="rank" id="hangId">
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
							</select>
						</div>
					</div>
					<div style="position:unset" class="price">
						<span>PRICE</span> <input type="text" placeholder="Giá tiền"
							name="price" id="priceId">
					</div>
					<div class="image">
						<span>IMAGE</span> <input type="file" name="img" id="imageId">
					</div>
					<button type="submit" class="btn-save-info">Save</button>
				</form>
			</div>
		</div>
	</main>
</body>
</html>