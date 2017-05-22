<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>
<body style="text-align: center">

   <input type="button" value="Show Contacts" name="showButton"
    onclick="openPage('show')"/>
    
   <input type="button" value="Add Contact" name="addButton"
    onclick="openPage('add')" />
    
    <input type="button" value="Edit Contact" name="editButton"
    onclick="openPage('edit')" />

	<script type="text/javascript">
 		function openPage(pageURL){
			window.location.href = pageURL;
		}
	</script>
	
	
	<br><br>
</body>
</html>