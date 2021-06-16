<%-- 
    Document   : editar
    Created on : 15-jun-2021, 19:42:50
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
        <h1>Contacto</h1>
        <form action="ContactoControlador" method="post">
            <input type="hidden" name="id" value="${c.id}">
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${c.nombre}"></td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="telefono" value="${c.telefono}"></td>
                </tr>
                <tr>
                    <td>Correo</td>
                    <td><input type="text" name="correo" value="${c.correo}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
                
            </table>
        </form>
    </body>
</html>
