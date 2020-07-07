<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>전화번호 리스트</h1>
		<p>입력한 정보 내역입니다.</p>
			
			<c:forEach items="${pList}" var="pList">
				<table border = '1'>
					<colgroup>
						<col style = "width: 150px;">
						<col style = "width: 200px;">
					</colgroup>
					
					<tbody>
						<tr>
							<td>이름 (name)</td>
							<td>${pList.name}</td>
						</tr>
						
						<tr>
							<td>핸드폰 (hp)</td>
							<td>${pList.hp}</td>
						</tr>
						
						<tr>
							<td>회사 (company)</td>
							<td>${pList.company}</td>
						</tr>
						
						<tr>
							<td><a href="${pageContext.request.contextPath}/phone/updateForm/${pList.personId}">수정</a></td>
							<td><a href="${pageContext.request.contextPath}/phone/delete/${pList.personId}">삭제</a></td>
						</tr>
					</tbody>
				</table>
				<br>
			</c:forEach>
		<a href = "${pageContext.request.contextPath}/phone/writeForm">번호 등록하기</a>
	</body>
</html>