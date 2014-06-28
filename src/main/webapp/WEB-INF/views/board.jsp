<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Board Contents</title>
</head>
<body>
<a href="<c:url value='/'/>">메인으로</a>
<a href="<c:url value='/writeform'/>">방명록 남기기</a>
<h2>방명록</h2>
<ul>
<c:forEach items="${documents}" var="document">
	<li> ${document.mail} <a href="/update/${document.id}"> 수정 </a> </li>
</c:forEach>
</ul>
</body>
</html>