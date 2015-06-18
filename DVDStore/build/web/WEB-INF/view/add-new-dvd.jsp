

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="<c:url value='createDVD'/>" method="post" style="clear: both">

            <h1>Ajouter un nouveau DVD</h1>

            <div class="dvdNew"> 
                <table style="border: none">
                    <tr> 
                        <td style="width: 130px; font-weight:bold;">Name: </td>
                        <td> 
                            <input type="text" name="newName"> 
                        </td>
                    </tr>
                    <tr> 
                        <td style="width: 130px; font-weight:bold;">Auteur: </td>
                        <td> 
                            <select name="auteurList"  id="auteurList" >
                                <c:forEach var="auteur" items="${auteurs}">
                                    <option value ="${auteur.id}">${auteur.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr> 
                        <td style="width: 130px; font-weight:bold;">Realisateur: </td>
                        <td> 
                            <select name="realisateurList"   id="realisateurList" >
                                <c:forEach var="realisateur" items="${realisateurs}">
                                    <option value ="${realisateur.id}">${realisateur.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                     <tr> 
                        <td style="width: 130px; font-weight:bold;">Fournisseur: </td>
                        <td> 
                            <select name="fournisseurList"   id="fournisseurList" >
                                <c:forEach var="fournisseur" items="${fournisseurs}">
                                    <option value ="${fournisseur.id}">${fournisseur.entreprise}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr> 
                        <td style="width: 130px; font-weight:bold;">Released: </td>
                        <td> 
                            <input type="text" name="selectedDate" id="selsectedDate" onClick="GetDate(this);">
                        </td>
                    </tr>
                    <tr> 
                        <td style="width: 130px; font-weight:bold;">Prix: </td>
                        <td>                                
                            <input type="text" name="newPrice"> 
                        </td>
                    </tr>

                    <tr> 
                        <td style="width: 130px; font-weight:bold;">Description: </td>
                        <td>
                            <input type="text" name="newDescription"> 
                        </td>
                    </tr>
                     <tr> 
                        <td style="width: 130px; font-weight:bold;">Quantité : </td>
                        <td>
                            <input type="text" name="newQuantity"> 
                        </td>
                    </tr>
                </table>

            </div>

        </select>

        <input type="submit"  value="  Ajouter  ">                 
    </form>
</body>
</html>
