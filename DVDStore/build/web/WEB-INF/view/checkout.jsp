

<script src="js/jquery.validate.js" type="text/javascript"></script>

<script type="text/javascript">

    $(document).ready(function(){
        $("#checkoutForm").validate({
            rules: {
                name: "required",
                email: {
                    required: true,
                    email: true
                },
                phone: {
                    required: true,
                    number: true,
                    minlength: 9
                },
                address: {
                    required: true
                },
                creditcard: {
                    required: true,
                    creditcard: true
                }
            }
        });
    });
</script>

<div id="singleColumn">

    <h2>Facturer</h2>

    <p>Afin de valider votre course, veuillez de nous fournir les informations suivants:</p>

    <c:if test="${!empty orderFailureFlag}">
        <p class="error">Nous ne pouvons pas traiter votre commande, essayez s'il vous plait!</p>
    </c:if>

    <form id="checkoutForm" action="<c:url value='purchase'/>" method="post">
        <table id="checkoutTable">
          <c:if test="${!empty validationErrorFlag}">
            <tr>
                <td colspan="2" style="text-align:left">
                    <span class="error smallText">S'il vous plait, fournissez les informations correctes pour les champs suivants:

                      <c:if test="${!empty nameError}">
                        <br><span class="indent"><strong>name</strong> (e.g., Tuan Hiep TRAN)</span>
                      </c:if>
                      <c:if test="${!empty emailError}">
                        <br><span class="indent"><strong>email</strong> (e.g., b.tuanhiep.tran88@gmail.com)</span>
                      </c:if>
                      <c:if test="${!empty phoneError}">
                        <br><span class="indent"><strong>phone</strong> (e.g., 222333444)</span>
                      </c:if>
                      <c:if test="${!empty addressError}">
                        <br><span class="indent"><strong>address</strong> (e.g., Grenoble 56)</span>
                      </c:if>
                      <c:if test="${!empty ccNumberError}">
                        <br><span class="indent"><strong>credit card</strong> (e.g., 1111222233334444)</span>
                      </c:if>

                    </span>
                </td>
            </tr>
          </c:if>
            <tr>
                <td><label for="name">name:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="name"
                           name="name"
                           value="${param.name}">
                </td>
            </tr>
            <tr>
                <td><label for="email">email:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="email"
                           name="email"
                           value="${param.email}">
                </td>
            </tr>
            <tr>
                <td><label for="phone">phone:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="16"
                           id="phone"
                           name="phone"
                           value="${param.phone}">
                </td>
            </tr>
            <tr>
                <td><label for="address">address:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="address"
                           name="address"
                           value="${param.address}">

                    <br>
                   
                </td>
            </tr>
            <tr>
                <td><label for="creditcard">credit card number:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="19"
                           id="creditcard"
                           name="creditcard"
                           value="${param.creditcard}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Confirmer">
                </td>
            </tr>
        </table>
    </form>

    <div id="infoBox">

        <ul>
            <li>Livraison le lendemain garantie</li>
            <li>Livraison coût ${initParam.deliverySurcharge} &euro; </li>
               
        </ul>

        <table id="priceBox">
            <tr>
                <td>Subtotal:</td>
                <td class="checkoutPriceColumn">
                     ${cart.subtotal} &euro;</td>
            </tr>
            <tr>
                <td>Livraison: </td>
                <td class="checkoutPriceColumn">
                     ${initParam.deliverySurcharge} &euro;</td>
            </tr>
            <tr>
                <td class="total"><strong>Total:</strong></td>
                <td class="total checkoutPriceColumn">
                     ${cart.total} &euro;</td>
            </tr>
        </table>
    </div>
</div>