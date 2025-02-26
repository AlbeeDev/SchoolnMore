<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Area Login</title>
  </head>
  <body>
      <h1>Accesso Area Utente e Amministratore</h1>
      <% if(request.getParameter("errore") != null) { %>
      <p>Accesso negato. credenziali errate</p>
      <% } %>
      <form action="login" method="post">
        <select name="ruolo" id="form">
          <option value="u">Utente</option>
          <option value="a">Admin</option>
        </select>
        <br>
        <input type="text" name="username">
        <br>
        <input type="password" name="password">
        <br>
        <input type="submit" value="accedi">
      </form>
      <a href="${pageContext.request.contextPath}/">abbandona</a>
  </body>
</html>
