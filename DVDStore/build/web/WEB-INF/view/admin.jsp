
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>MANAGEMENT</h1>

        <div style="width:800px;">
            <div style="float: left; width: 200px"> 
                <form action="add-new-dvd" method="post">
                    <input type="submit" name="Ajouter plus de dvd" value="Ajouter dvd">                 
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
            <div style="float: left; width: 150px"> 
                <form action="ongoing-command" method="post">
                    <input type="submit" name="Liste des commandes encours" value="En cours">                 
                </form>
            </div>
            <div style="float: left; width: 150px"> 
                <form action="executed-command" method="post">
                    <input type="submit" name="Liste des commandes effectuées" value="Effectuées">                 
                </form>
            </div>
        </div>
        <br>

        </br>
        <table style="border: solid 1px black; border-collapse:collapse;width: 830px;margin: 10px;">
            <tr>
                <th style="border: 1px solid black;">No </th>

                <th style="border: 1px solid black;">NAME</th>
                <th style="border: 1px solid black;">PRIX</th>
                <th style="border: 1px solid black;">STOCK</th>
                <th style="border: 1px solid black;">DATE DE SORTIE</th>
                <th style="border: 1px solid black;">DESCRIPTION</th>
                <th style="border: 1px solid black;">MODIFIER</th>

            </tr>

            <c:forEach var="dvd" items="${dvds}" varStatus="status">

                <tr>
                    <td style="border: 1px solid black;"><a href='dvd?${dvd.id}'>${dvd.id}</a></td>

                    <td style="border: 1px solid black;">${dvd.name}</td>
                    <td style="border: 1px solid black;">${dvd.price}</td>
                    <td style="border: 1px solid black;">${dvd.quantitystock}</td>
                    <td style="border: 1px solid black;">${dvd.lastRelease}</td>
                    <td style="border: 1px solid black;">${dvd.description}</td>
                    <td>
                        <form action="deleteDVD" method="post">
                            <input type="hidden" name="dvdId" value="${dvd.id}">
                            <input style="width: 80px" type="submit" name="Delete a DVD" value="Effacer">
                        </form>

                        <form action="editDVD" method="post">
                            <input type="hidden" name="editDVDId" value="${dvd.id}">
                            <button type="submit" style="width: 80px">Editer </button>
                            
                        </form>
                    </td>
                </tr>

            </c:forEach>

        </table>


    </body>
</html>
