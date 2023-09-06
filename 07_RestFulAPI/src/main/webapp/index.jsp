<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휴대전화 목록</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
	<h1>휴대전화 목록</h1>
	<table border="1">
		<thead>
			<tr>
				<th>모델번호</th>
				<th>모델이름</th>
				<th>가격</th>
				<th>제조사명</th>
			</tr>
		</thead>
		<tbody id="list">
		</tbody>
	</table>
	<h1>휴대전화 정보</h1>
	<form id="phoneFrm">
		모델번호 : <input type="text" name="num" id="num"><br> 모델명 :
		<input type="text" name="model" id="model"><br>
		     가격 : <input type="text" name="price" id="price"><br>
		     제조사 : <select	id="vcode" name="vcode">
			<option value="10">삼성</option>
			<option value="20">애플</option>
		</select> <br> 
		 <input type="button" value="추가하기" id="insert">
		 <input type="button" value="수정하기" id="update">
		 <input type="button" value="삭제하기" id="delete">
			
	</form>
	<script>
	function list() {
		$.ajax({
			url : 'http://localhost:8080/api/phone',
			type : 'GET',
			success : function(data) {
			var mobileList = data;					
				let html = '';
				for(let phone of data) {
						html += '<tr>' +
				'<td class="num">' + phone.num + '</td>'+
				'<td>' + phone.model + '</td>'+
				'<td>' + phone.price + '</td>'+
				'<td>' + phone.company.vendor + '</td>'+
			'</tr>';							  		
		}								
		$('#list').append(html);
	},
	error: function(data) {
		alert('에러');
}
    });
}
	
list();
// 상세 조회
$('#list').on('click', '.num', function() {
	console.log($(this).text());
	function list() {
	$.ajax({
		url : 'http://localhost:8080/api/phone' + $(this).text(),
		type : 'GET',
		success : function(data) {
		$("#num").val(data.num);
		$("#model").val(data.model);
		$("#price").val(data.model);
		$("#vcode").val(data.vcode);
	}


 });
}
	
});

// 추가
$('#insert').on('click', function() {
		
	$.ajax({
		// JSON 방식으로 전달
		let phone = {
			num : $("#num"),
			model : $("#model").val(),
			price : $("#price").val(),
			vcode : $("#vcode").val()
		};
		type: 'post',
		url : 'http://localhost:8080/api/phone',
		data :'JSON.stringify(phone)' ,
		contentType : 'application/json',
		
		success: function(){
			
			list();
		}
	});
});

// 수정
$('#update').on('click', function() {
	
	$.ajax({
		// JSON 방식으로 전달
		let phone = {
			num : $("#num"),
			model : $("#model").val(),
			price : $("#price").val(),
			vcode : $("#vcode").val()
		};
		type: 'put',
		url : 'http://localhost:8080/api/phone',
		data :'JSON.stringify(phone)' ,
		contentType : 'application/json',
		
		success: function(){
			
			list();
		}
});
});

// 삭제
$('#delete').on('click', function() {
	$.ajax({
		url : 'http://localhost:8080/api/phone' + $('#num').val,
		type : 'delete',
		success : function(data) {
		list();
		num : $("#num").val("");
		model : $("#model").val("");
		price : $("#price").val("");
		vcode : $("#vcode").val("10");
		}
	});
});
</script>

</body>
</html>