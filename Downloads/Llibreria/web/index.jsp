<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body bgcolor="#FFFF99" >
        <%@ include file="myHeader.html" %>
        <h1 align="center" >Seleccionar opció:</h1><br><br><br>
    <tr align="center"> 
    <a  href='afegir.jsp'>AFEGIR NOU LLIBRE</a><br><br>
    <a href='cerca.jsp'>CERCAR LLIBRE PER ISBN</a><br><br>
    <a href='cercaTitol.jsp'>CERCAR LLIBRE PER TITOL</a><br><br>
    <a href='GestioLlibres?accio=cercaTots.jsp'>LLISTAR TOTS ELS LLIBRES</a><br><br>
    <a href='elimina.jsp'>ELIMINAR LLIBRE PER ISBN</a><br><br>

    <p>&nbsp;</p>
    <%@ include file="myFooter.html" %>
</body>
</html>