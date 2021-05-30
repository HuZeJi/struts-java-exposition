<%-- 
    Document   : Delete
    Created on : May 30, 2021, 2:08:14 PM
    Author     : vhjim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/delete.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Lista de heroes</title>
    </head>
    <body>
        <header>
            <h1>Eliminar heroe</h1>
        </header>
        <main>
            <h2>
                <s:property value="msg" />
            </h2>
            <div class="icon"><i class="fa fa-info-circle"></i></div>
        </main>
        <h5>

            <a href="report.action">
                <i class="fa fa-arrow-left"></i> Todos los superheroes
            </a>
        </h5>
    </body>
</html>
