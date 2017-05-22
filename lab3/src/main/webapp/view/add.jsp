<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
 
<html>
	<body style="text-align: center"> 
		<div style="width:70%;height:100%;border:1px solid #000;margin: auto;background-color: lightblue;">
			<%@include file="header.jsp" %>
		
			<h1>Add a contact</h1>
			 
			<form:form method="POST">
				<p>
					Name:
					<input type="text" name="name" />
				</p>
				<p>
					Email:
					<input type="text" name="mail" />
				</p>
				<p>
					Number:
					<input type="text" name="number" />
				</p>
				<p>
					Info:
					<input type="text" name="info" />
				</p>
			 
				<input type="submit" />
			</form:form>
			
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>