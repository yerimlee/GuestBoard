<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Board Contents</title>
</head>
<body>
<p><a href="<c:url value='/'/>">메인으로</a></p>
<h2><a href="<c:url value='/writeform'/>">방명록 남기기</a></h2>

<c:forEach items="${documents}" var="document">

	<table>
		<tr height="1" bgcolor="#82B5DF"><td colspan="3"></td></tr>
		<tr>
			<td align="left" width="130">작성자 메일</td>
			<td width="0">&nbsp;</td>
			<td align="center"><strong>${document.mail}</strong></td>
		</tr>
		<tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
		<tr>
			<td align="left" width="130">작성시간</td>
			<td width="0">&nbsp;</td>
			<td align="center"><strong>${document.time}</strong></td>
		</tr>
		<tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
		<tr>
			<td colspan="3" align="left" width="500" height="auto"
			 bgcolor="#fffafa" style="word-break:break-all" style="padding: 10px;">
			<strong>${document.content}</strong>
			</td>
		</tr>
		<tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
		<tr>
			<td align="left" width="130">최종 수정시간</td>
			<td width="0">&nbsp;</td>
			<td align="center"><strong>${document.updatetime}</strong></td>
		</tr>
		<tr height="1" bgcolor="#dddddd"><td colspan="3"></td></tr>
		<tr>
			<td width="0">&nbsp;</td>
			<td width="0">&nbsp;</td>
			<td align="right"> <a href="/update/${document.id}"> 수정 </a> </td>
		</tr>
    		
    	<tr height="1" bgcolor="#82B5DF"><td colspan="3"></td></tr>
    	<tr>
            <td width="0" colspan="3" height="40">&nbsp;</td>
		</tr>

	</table>
	
</c:forEach>

</body>
</html>