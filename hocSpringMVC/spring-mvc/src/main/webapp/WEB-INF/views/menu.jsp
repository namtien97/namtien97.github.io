<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul>
	<c:forEach var="item" items="${menu}">
		<li>${item}</li>
	</c:forEach>
</ul>