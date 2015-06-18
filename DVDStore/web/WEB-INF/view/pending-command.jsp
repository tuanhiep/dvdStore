
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pending command</title>
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
        <h1>En Attente</h1>

        <table style="border: solid 1px black; border-collapse:collapse;width: 830px;margin: 10px;">
            <th style="border: 1px solid blue;">COMMANDE</th>
            <th style="border: 1px solid blue;">DVD</th>
            <th style="border: 1px solid blue;">MANQUE</th>
            <th style="border: 1px solid blue;">FOURNISSEUR</th>
            <th style="border: 1px solid blue;">EMAIL</th>
            <tbody>


                <c:forEach var="pending" items="${pendingMap}">
                    <tr>
                        <td style="border: 1px solid blue;" rowspan="${pending.key.count+1}">   <!-- rowspan is the number of dvd increased by 1-->

                            <span> <a href='command?${pending.key.commande.id}'>COMMANDE ${pending.key.commande.id}</a>  </span> <br/>
                            <span style="font-size: small">${pending.key.commande.clientId.name}</span><br/>
                            <span style="font-size: small">${pending.key.commande.clientId.address}</span><br/>
                            <span style="font-size: small">${pending.key.commande.dateCreated}</span>
                            <br></br>
                            <form action="sendEmail" method="post">
                                <input type="submit" value="Demander par email">
                            </form>
                            <br>

                            </br>
                        </td>


                    </tr>
                    <c:forEach var="missingDVD" items="${pending.value}">

                        <tr>
                            <td style="border: 1px solid blue;">${missingDVD.dvd.name}</td>
                            <td style="border: 1px solid blue;">${missingDVD.missquantity}</td>
                            <td style="border: 1px solid blue;">${missingDVD.dvd.fournisseurId.entreprise}</td>
                            <td style="border: 1px solid blue;">${missingDVD.dvd.fournisseurId.email}</td>
                        </tr>

                    </c:forEach>

                </c:forEach>

            </tbody>

        </table>
    </body>
</html>
