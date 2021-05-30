<%-- 
    Document   : Report
    Created on : May 30, 2021, 1:54:56 PM
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
        <link rel="stylesheet" href="./css/index.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Lista de heroes</title>
    </head>
    <body>
        <header>
            <h1>Listado de heroes</h1>
        </header>
        <main>
            <div class="action-area">
                <div class="btn-add">
                    <a href="crear.action">
                        <i class="fa fa-plus"></i>
                    </a>
                </div>
            </div>
            <s:if test="noData==false">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Superpoder</th> 
                            <th>Nombre Real</th>
                            <th>Editorial</th>
                            <th class="actions">Acciones</th>
                        </tr>
                    </thead>
                    <s:iterator value="shList">
                        <tr> 
                            <td><s:property value="id" /></td>
                            <td><s:property value="s_name" /></td>
                            <td><s:property value="superpower" /></td>
                            <td><s:property value="r_name" /></td>
                            <td><s:property value="editorial" /></td>
                            <td>
                                <div class="actions">
                                    <a href="update.action?submitType=updateData&id=<s:property value="id"/>"><i class="fa fa-edit"></i></a>  
                                    <a href="delete.action?id=<s:property value="id"/>"><i class="fa fa-trash"></i></i></a>                                       
                                    <i class="fa fa-info"></i>
                                </div>
                            </td>
                        </tr>
                    </s:iterator>
                </table>
            </s:if>
            <s:else>
                <a href="report.action">
                    Cargar datos
                </a>
                <span style="color: red; margin: 25px">No se han encontrado datos</span>
            </s:else>
        </main>
    </body>
</html>

