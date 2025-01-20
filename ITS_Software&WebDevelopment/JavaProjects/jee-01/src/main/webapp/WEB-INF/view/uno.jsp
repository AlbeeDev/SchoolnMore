<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link href="static/css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <%
            List<String> lista = new ArrayList<>();
            lista.add("elemento1");
            lista.add("elemento2");
            lista.add("elemento3");
        %>
        <img src="static/images/image.png" alt="null">
        <h1>benvenuto ${nome}</h1>
        <h2>Ciao <%= request.getAttribute("nome") %></h2>
        <ul>
            <% for(String elemento : lista){ %>
                    <li><%=elemento%></li>
            <% } %>
        </ul>
    </body>
</html>
