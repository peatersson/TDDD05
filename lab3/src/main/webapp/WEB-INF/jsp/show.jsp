<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<body>
 
	<h1>Contacts</h1>
 
	<c:forEach items="${contactList}" var="contact">
		<p>
			ID: ${contact.id}, Name: ${contact.name}, mail: ${contact.mail}, number: ${contact.number}, info: ${contact.info}
		</p>
	</c:forEach>
 
</body>
</html>