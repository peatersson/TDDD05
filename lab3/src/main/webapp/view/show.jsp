<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
	
<html>
	<body>
		<div style="width:70%;height:100%;border:1px solid #000;margin: auto;background-color: lightblue;">

			<%@include file="header.jsp" %>
	 
			<h1>Contacts</h1>
		 
			<c:forEach items="${contactList}" var="contact">
				<p>
					ID: ${contact.id}, Name: ${contact.name}, mail: ${contact.mail}, number: ${contact.number}, info: ${contact.info}
				</p>
			</c:forEach>
			
			<%@include file="footer.jsp" %>
		</div>
	 
	</body>
</html>