<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello</title>
    <link href="style.css" rel="stylesheet" type="text/css">
    <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
</head>
<body>
<h1><%
    out.println("Hello Friend");
%></h1>


<div>
    <%
        int n = Integer.parseInt(request.getParameter("n"));
//        out.println("<table style=\"background: rgba("+ n +","+ n*2 + ","+ n*3 +",0.5)\">");
        out.println("<table style=\"background: linear-gradient(rgba("+ n +","+ n*2 + ","+ n +",0.5),rgba("+ n +","+ n + ","+ n*3 +",0.5))\">");
        for (int x =1; x<=n;x++){
            out.println("<tr>");
            for(int y=1;y<=n;y++){
                out.println("<td style='color: rgb("+2*n+ "," + (4*n) + ","+ (6*n)+")'>" + x*y + "</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
    %>
</div>

</body>
</html>
