<%--
  Created by IntelliJ IDEA.
  User: jeansmits
  Date: 25/06/15
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ attribute name="n" required="true"

%>

<html>
<head>
    <title>tagtest</title>
</head>
<body>
<div>
  <%
//    int n = Integer.parseInt(pageContext.getAttribute("n").toString());
    out.println("<table>");
    for (int x =1; x<=Integer.parseInt(n);x++){
      out.println("<tr>");
      for(int y=1;y<=Integer.parseInt(n);y++){
        out.println("<td>" + x*y + "</td>");
      }
      out.println("</tr>");
    }
    out.println("</table>");
  %>
</div>


</body>
</html>
