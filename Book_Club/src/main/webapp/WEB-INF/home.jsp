<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Club</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h1>Welcome, <c:out value="${user.userName}"/></h1>
		
		<h3>Books from everyone shelves:</h3>
		<a href="/logout">logout</a>
		<a href="/addPage">+ Add to my shelf</a>
		
		<table class="table">
		
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Owner</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="book" items="${books}">
			<c:if test="${user.id != book.borrower.id }">
				<tr>
					<td><c:out value="${book.id}"/></td>
					<td><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
					<td><c:out value="${book.author}"/></td>
					<td><c:out value="${book.user.userName}"/></td>
					<c:if test="${user == book.user }">
						<td><a href="/books/${book.id}/edit">edit</a> 
							<form action="/book/${book.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete"> 
							<a href="/books/${book.id}">delete</a></td>							
							</form>						
					</c:if>
					<c:if test="${user != book.user }">
						<td><a href="/books/${book.id}/borrow">borrow</a></td>
					</c:if>
				</tr>
			</c:if>
			
				
			</c:forEach>
		
		</table>
		
		<h3>Book I'm borrowing</h3>
		
		<table class="table">
		
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Owner</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="book" items="${books}">
				<c:if test="${user.id == book.borrower.id }">
					<tr>
					<td><c:out value="${book.id}"/></td>
					<td><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
					<td><c:out value="${book.author}"/></td>
					<td><c:out value="${book.user.userName}"/></td>
					<c:if test="${user != book.user }">
						<td><a href="/books/${book.id}/return">return</a></td>
					</c:if>
				</tr>
				</c:if>
				
			</c:forEach>
		
		</table>
	</div>

</body>
</html>