<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
<script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 등록 창</title>
</head>
<body>
<a href="<c:url value='/board'/>">돌아가기</a>
<form:form commandName="document" action="/board" method="POST">
    <p>
        <label><strong>메일</strong></label>
        <form:input path="mail" size="30"/>
        <form:errors path="mail" cssClass="smdis-error-message"/>
 	</p>
 	<p>       
        <label><strong>패스워드</strong></label>
        <form:input path="password" type="password" size="25"/>
        <form:errors path="password" cssClass="smdis-error-message"/>
	</p>
    <p>
        <form:textarea path="content" rows="10" cols="50" charset="UTF-8"/>
        <form:errors path="content" cssClass="smdis-error-message"/>
    </p>
    <p> <input type="submit" value="저장"/> </p>
</form:form>
</body>

<script type="text/javascript">
$("form").submit(function() {
	var email = $("input:first").val();
	if (!validEmail(email)) {
		alert("메일이 잘못되었습니다!");
		$("input:first").focus();  
	    return false;  
	}
});

function validEmail(v) {
    var r = new RegExp("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
    return (v.match(r) == null) ? false : true;
}
</script>
</html>