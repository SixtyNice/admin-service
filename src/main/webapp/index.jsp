<%@ page import="com.accenture.tveratc.bank.Model.LoginDAO" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin-service</title>
    </head>
    <body>
    <br>
<h1>ID: <%= LoginDAO.getClientInfo().getId()%></h1
<br>
<h1>Name: <%= LoginDAO.getClientInfo().getName()%></h1
<br>
<h1>LastName: <%= LoginDAO.getClientInfo().getLastName()%></h1
<br>
<h1>Middle Name: <%= LoginDAO.getClientInfo().getMiddleName()%></h1
<br>
<h1>Role: <%= LoginDAO.getClientInfo().getRole()%></h1
</body>
</html>
