<%-- 
    Document   : Crear
    Created on : May 30, 2021, 1:45:10 PM
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
        <link rel="stylesheet" href="./css/crear.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Lista de heroes</title>
    </head>
    <body>
        <header>
            <h1>Crear heroe</h1>
        </header>
        <main>
            <s:form action="crear.action" method="post">
                <s:textfield label="Identificador" class="row" type="text" name="id"/>
                <s:textfield label="Nombre de superheroe" class="row" type="text" name="s_name"/>
                <s:textfield label="Superpoder" class="row" type="text" name="superpower"/>
                <s:textfield label="Nombre Real" class="row" type="text" name="r_name"/>
                <s:textfield label="Editorial" class="row" type="text" name="editorial"/>
                <s:textarea label="Historia" class="row" name="history" cols="30" rows="10"/>


                <s:submit class="btn-save" value="Guardar"/>
            <span style="color: red; margin: 25px"><s:property value="msg" /></span>
            </s:form>
        </main>
        <h5>

            <a href="report.action">
                <i class="fa fa-arrow-left"></i> Todos los superheroes
            </a>
        </h5>
    </body>
</html>
