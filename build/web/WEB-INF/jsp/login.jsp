<%-- 
    Document   : login
    Created on : Dec 2, 2021, 10:18:07 AM
    Author     : Azka Pratama
--%>
<%@include file="/WEB-INF/jsp/include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Halaman Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="get" modelAttribute="emp" action="login/save.html">
            <table>
                <tr>
                    <td>Username</td>
                    <td>:</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>:</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" value="login"/></td>
                </tr>
                <tr>
                    <td colspan="3">${message}</td>
                </tr>
            </table>
        </form>
    </body>
</html>
