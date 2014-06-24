<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Grade Main Page</title>
</head>
<body>
        <table border=1>
               <tr>
                       <td>Snumber</td>
                       <td>Name</td>
                       <td>Korean</td>
                       <td>English</td>
                       <td>Math</td>
                       <td>Sum</td>
                       <td>Avr</td>
                       <td>Grade</td>
                       <td>Rank</td>
                       <td>Function</td>
               </tr>
               <c:forEach items="${list}" var="grade" step="1">
               <tr>
                       <td><c:out value="${grade.snumber}" /></td>
                       <td><c:out value="${grade.name}" /></td>
                       <td><c:out value="${grade.korean}" /></td>
                       <td><c:out value="${grade.english}" /></td>
                       <td><c:out value="${grade.math}" /></td>
                       <td><c:out value="${grade.sum}" /></td>
                       <td><c:out value="${grade.avr}" /></td>
                       <td><c:out value="${grade.grade}" /></td>
                       <td><c:out value="${grade.rank}" /></td>
                       <td align=center>U / D</td>
               </tr>
               </c:forEach>
        </table>
        <h1>
        </h1>
</body>
</html>