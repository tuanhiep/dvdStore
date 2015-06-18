<%-- 
    Document   : dvd
    Created on : Jan 25, 2014, 6:33:52 AM
    Author     : Strong man
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DVD Page</title>
    </head>
    <body>
        <h1>${selectedDvd.name}</h1>

        <div class="dvdDetailSummary" > 
            <img src="${initParam.dvdImagePath}${selectedDvd.name}.jpg" id="imageDVD" alt="${selectedDvd.name}" >

            <div class="dvdDetail"> 
                <table style="border: none">
                    <tr> 
                        <td style="width: 130px; font-weight:bold;">Auteur: </td>
                        <td> ${selectedDvd.auteurId.name}</td>
                    </tr>
                    <tr> 
                        <td style="width: 130px; font-weight:bold;">Realisateur: </td>
                        <td> ${selectedDvd.realisateurId.name}</td>
                    </tr>
                    <tr> 
                        <td style="width: 130px; font-weight:bold;">Released: </td>

                        <td> ${selectedDvd.lastRelease}</td>

                    </tr>
                    <tr> 
                        <td style="width: 130px; font-weight:bold;">Prix: </td>
                        <td> <fmt:formatNumber type="currency" currencySymbol="&euro; " value="${selectedDvd.price}"/></td>
                    </tr>
                    
                    <tr> 
                        <td style="width: 130px; font-weight:bold;">Description: </td>
                        <td>${selectedDvd.description}  </td>
                    </tr>
                </table>

            </div>

            <form action="addToCartFromDVD" method="post" style="clear: both">
                <input type="hidden" name="dvdId" value="${selectedDvd.id}">
                <input type="submit" name="Add to cart from dvd" value="  Prenez   ">                 
            </form>
        </div>
    </body>
</html>
