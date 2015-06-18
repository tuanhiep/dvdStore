

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit DVD Page</title>
    </head>
    <body>
        <h1>Editer DVD</h1>
        <div class="dvdDetailSummary" > 
            <form action="updateDVD" method="post"">

                <img src="${initParam.dvdImagePath}${selectedDvd.name}.jpg" id="imageDVD" alt="${selectedDvd.name}" >

                <div class="dvdDetail"> 
                    <table style="border: none">
                        <tr> 
                            <td style="width: 130px; font-weight:bold;">DVD's name: </td>
                            <td> 
                                <input type="text"  name="newName" value="${selectedDvd.name}"
                            </td>
                        </tr>
                        <tr> 
                            <td style="width: 130px; font-weight:bold;">Auteur: </td>
                            <td> 
                                <select name="auteurList" id="auteurList" >
                                    <c:forEach var="auteur" items="${auteurs}">
                                        <c:choose>
                                            <c:when test="${auteur.id == selectedDvd.auteurId.id}">
                                                <option selected="selected" value="${auteur.id}">${auteur.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option  value="${auteur.id}">${auteur.name}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr> 
                            <td style="width: 130px; font-weight:bold;">Realisateur: </td>
                            <td> 
                                <select name="realisateurList"   id="realisateurList" >
                                    <c:forEach var="realisateur" items="${realisateurs}">
                                        <c:choose>
                                            <c:when test="${realisateur.id == selectedDvd.realisateurId.id}">
                                                <option selected="selected" value="${realisateur.id}">${realisateur.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option  value="${realisateur.id}">${realisateur.name}</option>
                                            </c:otherwise>
                                        </c:choose>
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
                                <input type="text" name="newReleasedDate" value =""${selectedDvd.lastRelease}>
                            </td>

                        </tr>
                        <tr> 
                            <td style="width: 130px; font-weight:bold;">Prix: </td>
                            <td> 
                                <fmt:formatNumber type="currency" currencySymbol="&euro; " value=""/>
                                <input type="text" name="newPrice" value="${selectedDvd.price}" >
                            </td>
                        </tr>

                        <tr> 
                            <td style="width: 130px; font-weight:bold;">Description: </td>
                            <td>
                                <input type="text" name="newDescription" value="${selectedDvd.description}">
                            </td>
                        </tr>
                        <tr> 
                            <td style="width: 130px; font-weight:bold;">Quantité : </td>
                            <td>
                                <input type="text" name="newQuantity" value="${selectedDvd.quantitystock}"> 
                            </td>
                        </tr>
                    </table>

                </div>
                <input type="hidden" value="${selectedDvd.id}" name="selectedDvdId">
                <input type="submit" name="Update dvd" value="  Update   ">                 
            </form>
        </div>
    </body>
</html>
