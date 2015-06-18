<div id="content">
    <div id="search">
        <form action="search-result" method="post">
            <input type="text" size="50" value="" name="searchText">
            <select name="searchType"   id="searchType">
                <option value ="DVD">DVD</option>
                <option value ="Auteur">Auteur</option>
                <option value ="Réalisateur">Réalisateur</option>
            </select>
            <input type="submit" name="submit" value="Recherchez">
        </form>

    </div>

    <div id="dvd-list"> 

        <c:forEach var="dvd" items="${dvds}">

            <div class="DVDBox" >
                <a href="<c:url value='dvd?${dvd.id}'/>">
                    <img src="${initParam.dvdImagePath}${dvd.name}.jpg" alt="${dvd.name}">  
                    <span class="DVDLabelText">${dvd.name}</span>   <br />
                </a>
                <span class="DVDSummary">Auteur : ${dvd.auteurId.name} </span> <br />
                <span class="DVDSummary">Prix : <fmt:formatNumber type="currency" currencySymbol="&euro; " value="${dvd.price}"/> </span>

                <form action="addToCartFromIndex" method="post">
                    <input type="hidden" name="dvdId" value="${dvd.id}">
                    <input type="submit" name="Add to cart" value="  Prenez   ">                 
                </form>
            </div>


        </c:forEach>

    </div>

</div>

