
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<div id="content">
    <div id="search">Resultat de votre recherche</div>
    
    <div id="dvd-list"> 
        
        <c:forEach var="dvd" items="${dvdFound}">
        <div class="DVDBox" >
                <a href="dvd?${dvd.id}">
                    <img src="${initParam.dvdImagePath}${dvd.name}.jpg" alt="${dvd.name}">  
                    <span class="DVDLabelText">${dvd.name}</span>   <br />
                </a>
                <span class="DVDSummary">Auteur :${dvd.auteurId.name} </span> <br />
                <span class="DVDSummary">Prix :${dvd.price} $ </span>

                <form action="addToCartFromResult" method="post">
                    <input type="hidden" name="dvdId" value="${dvd.id}">
                    <input type="submit" name="Add to cart" value="   Prenez  ">                 
                </form>
            </div>      
        </c:forEach>
                  
    </div>

</div>

