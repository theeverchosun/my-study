<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원등록</title>

</head>
<body>
	<h1>회원 가입</h1>
	<form action="/member/insert" method="post">
		<label>
			이름:
			<input type="text" name="name" required>
		</label>
		
		<label>
				이메일:
				<input type="text" name="email" required>
				</label>
				
				<label>
						나이:
						<input type="number" name="age" required value="20">
					</label> <br>
					
					<input type="submit" value="가입">
					
	</form>
	
	
</body>


</html>