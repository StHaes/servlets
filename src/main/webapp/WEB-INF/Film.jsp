<%@ page import="java.util.List" %>
<%@ page import="be.vdab.Film" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="m" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: jeansmits
  Date: 24/06/15
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie list</title>
  <link href="style.css" rel="stylesheet" type="text/css">
  <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
</head>
<>
<h1>List of films to make</h1>
<%
  List<Film> films = (List<Film>)request.getAttribute("Films");
  out.println("<table>");
  out.println("<th>Title</th>");
  out.println("<th>Director</th>");
  for (Film film : films) {
    out.println("<tr>");
    out.println("<td>"+ film.getTitle() +"</td>");
    out.println("<td>"+ film.getDirector() +"</td>");
    out.println("</tr>");
  }
  out.println("</table>");
%>
<div><h1>The second table is way easier.</h1></div>
<table>
  <th>Title</th>
  <th>Director</th>
<c:forEach var="Film" items="${Films}">
  <tr>
    <td>${Film.title}</td>
    <td>${Film.director}</td>
  </tr>
</c:forEach>
</table>
<div><h1>This is plain Magic</h1></div>

<div><m:Multiplytag n="20"></m:Multiplytag></div>

</body>
</html>
