

<div id="singleColumn">

    <c:choose>
        <c:when test="${cart.numberOfItems > 1}">
            <p>Votre caddie contient  ${cart.numberOfItems} DVDs.</p>
        </c:when>
        <c:when test="${cart.numberOfItems == 1}">
            <p>Votre caddie contient ${cart.numberOfItems} DVD.</p>
        </c:when>
        <c:otherwise>
            <p>Votre caddie est vide </p>
        </c:otherwise>
    </c:choose>

    <div id="actionBar">
        
        <c:if test="${!empty cart && cart.numberOfItems != 0}">
            <a href="viewCart?clear=true" class="bubble hMargin">Vider cette caddie</a>
        </c:if>

        <a href="index.jsp" class="bubble hMargin">Continuer votre course</a>

        <c:if test="${!empty cart && cart.numberOfItems != 0}">
            <a href="checkout" class="bubble hMargin">Aller à facturer </a>
        </c:if>
    </div>

    <c:if test="${!empty cart && cart.numberOfItems != 0}">

      <h4 id="subtotal">subtotal: &euro; ${cart.subtotal}</h4>

      <table id="cartTable">

        <tr class="header">
            <th>DVD</th>
            <th>Nom</th>
            <th>Prix</th>
            <th>Quantité</th>
        </tr>

        <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">

          <c:set var="dvd" value="${cartItem.dvd}"/>

          <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
            <td>
              <img src="${initParam.dvdImagePath}${dvd.name}.jpg"
                   alt="${dvd.name}">
            </td>

            <td>${dvd.name}</td>

            <td>
                &euro; ${cartItem.total}
                <br>
                <span class="smallText">( &euro; ${dvd.price} / unité )</span>
            </td>

            <td>
                <form action="updateCart" method="post">
                    <input type="hidden"
                           name="dvdId"
                           value="${dvd.id}">
                    <input type="text"
                           maxlength="2"
                           size="2"
                           value="${cartItem.quantity}"
                           name="quantity"
                           style="margin:5px">
                    <input type="submit"
                           name="submit"
                           value="Mettre à jour">
                </form>
            </td>
          </tr>

        </c:forEach>

      </table>

    </c:if>
</div>