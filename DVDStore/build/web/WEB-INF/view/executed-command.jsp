<%-- 
    Document   : executed-command
    Created on : Jan 31, 2014, 10:17:36 PM
    Author     : Strong man
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Executed command</title>
    </head>
    <body>
        <br>

        </br>
        <div style="width:800px;">
            <div style="float: left; width: 200px"> 
                <form action="admin" method="get">
                    <input type="submit" name="Page Accueil Admin" value="Accueil">                 
                </form>
            </div>
            <div style="float: left; width: 150px"> 
                <form action="all-command" method="post">
                    <input type="submit" name="Liste des commandes" value="Synthèse">                 
                </form>
            </div>
            <div style="float: left; width: 150px"> 
                <form action="pending-command" method="post">
                    <input type="submit" name="Liste des commandes en attente" value="En attente">                 
                </form>
            </div>
            <div style="float: right; width: 150px"> 
                <form action="executed-command" method="post">
                    <input type="submit" name="Liste des commandes effectuées" value="Effectuées">                 
                </form>
            </div>
            <div style="float: right; width: 150px"> 
                <form action="ongoing-command" method="post">
                    <input type="submit" name="Liste des commandes encours" value="En cours">                 
                </form>
            </div>

        </div>
        <br>

        </br>
        <h1>Effectuées</h1>
        <table style="border: solid 1px black; border-collapse:collapse;width: 830px;margin: 10px;">
            <tr>
                <th style="border: 1px solid black;">ID  </th>
                <th style="border: 1px solid black;">CLIENT</th>
                <th style="border: 1px solid black;">DATE</th>
                <th style="border: 1px solid black;">ETAT</th>                
            </tr>

            <c:forEach var="commande" items="${executedCommandes}">

                <tr>
                    <td style="border: 1px solid black;"><a href='command?${commande.id}'> ${commande.id}</a></td>
                    <td style="border: 1px solid black;">${commande.clientId.name}</td>
                    <td style="border: 1px solid black;">${commande.dateCreated}</td>
                    <td style="border: 1px solid black;">${commande.state}</td>
                </tr>

            </c:forEach>

        </table>
    </body>
</html>
