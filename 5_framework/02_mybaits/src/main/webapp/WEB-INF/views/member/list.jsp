<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

</head>
<body>
	<%-- message 값이  있을경우 alert로 메시지 내용 출력--%>
	<c:if test="${message != null}">
		<script>
		alert("${message}");	
		<c:remove var="message"/>
		</script>
	</c:if>
	<h1>회원 목록</h1>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>이메일</th>
				<th>나이</th>
				
				
			</tr>
		</thead>
		<tobody>
			<%--JSTL 반복문을 사용하여 조회결과 (memberList)를 한행씩 출력--%>
			<c:forEach var="m" items="${memberList}">
				<tr>
					<td>${m.id}</td>
					<td>${m.name}</td>
					<td>${m.email}</td>
					<td>${m.age}</td>
				</tr>
			</c:forEach>
			
		</tobody>
	</table>
	
	
	
	
</body>