<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 15-jun-2021, 19:20:22
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Contactos</h1>
        <a href="ContactoControlador?action=add">Nuevo</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Telefono</th>
                <th>Correo</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${lista}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.telefono}</td>
                    <td>${item.correo}</td>
                    <td><a href="ContactoControlador?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="ContactoControlador?action=delete&id=${item.id}"
                           onclick="return(confirm('esta seguro de eliminar'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
