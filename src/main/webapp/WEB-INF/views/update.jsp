<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
<script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
<body>
<a href="<c:url value='/' />">돌아가기</a>
<form:form commandName="document" action="/update" method="POST">

	<p>       
        <label><strong>패스워드</strong></label>
        <input type="password" size="25"/>
	</p>
    <p>
        <form:textarea path="content" rows="10" cols="50" charset="UTF-8"/>
        <form:errors path="content" cssClass="smdis-error-message"/>
    </p>
    
	<input type="submit" value="저장" />
</form:form>
</body>
</head>

<script type="text/javascript">
$("form").submit(function() {
	var pw = '<c:out value="${document.password}"/>';
	if ($("input:first").val() == pw) {
        return true;
    }
	alert("비번 불일치!");
	return false;
});
</script>

</html>

