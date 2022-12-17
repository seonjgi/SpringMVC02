<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ---------------------------------------------------------- -->
<link rel="stylesheet" type="text/css" href="./css/layout.css">
<script src="./js/userCheck.js"></script>
<!-- ---------------------------------------------------------- -->

<c:if test="${result=='ok' }">
	<div class='container m2'>
		<h3>
			ID로 [<span style='color: red; font-weight: bold;'>${userid }
			</span>]을 사용할 수 있습니다
		</h3>
		<br>
		<button onclick="setId('${userid }')">닫 기</button>
	</div>
</c:if>


<c:if test="${result=='no' }">
	<div class='container m2'>
		<h3>
			ID로 [<span style='color: red; font-weight: bold;'>${userid }
			</span>]는 이미 사용 중 입니다
		</h3>
	</div>
	
	<div class="container m2" style="margin-top: 2em">
		<form name="idf" action="idCheck.do" method="post">
			<label for="userid">아이디</label> <input type="text" name="userid"
				id="userid" placeholder="User ID" autofocus="autofocus">
			<button type="button" onclick="id_check()">확 인</button>
		</form>
	</div>
</c:if>