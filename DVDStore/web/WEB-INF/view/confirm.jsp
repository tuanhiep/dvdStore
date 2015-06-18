

<div id="singleColumn">

    <p id="confirmationText">
        <strong>Votre facture est traitée avec succès et vos articles seront délivrés pendant le temps 24 h.</strong>
        <br><br>
        Veuillez noter votre code de confirmation:
        <strong>${commandeRecord.confirmationNumber}</strong>
        <br>
        Si vous avez des soucis concernant votre facture, n'hésistez pas à nous contacter par <a href="#">contactez- nous</a>.
        <br><br>
        Merci pour votre course chez notre DVDStore !
       
    </p>

    <div class="summaryColumn" >

        <table id="orderSummaryTable" class="detailsTable">
            <tr class="header">
                <th colspan="3">Récapitulatif de commande</th>
            </tr>

            <tr class="tableHeading">
                <td>DVD</td>
                <td>Quantité</td>
                <td>Prix</td>
            </tr>

            <c:forEach var="dvdCommande" items="${dvdCommandes}" varStatus="iter">

                <tr class="${((iter.index % 2) != 0) ? 'lightBlue' : 'white'}">
                    <td>${dvdCorrespondants[iter.index].name}</td>
                    <td class="quantityColumn">
                        ${dvdCommande.quantity}
                    </td>
                    <td class="confirmationPriceColumn">
                         ${dvdCorrespondants[iter.index].price *dvdCommande.quantity} &euro;
                    </td>
                </tr>

            </c:forEach>

            <tr class="lightBlue"><td colspan="3" style="padding: 0 20px"><hr></td></tr>

            <tr class="lightBlue">
                <td colspan="2" id="deliverySurchargeCellLeft">Livraison en supplément</td>
                <td id="deliverySurchargeCellRight"> ${initParam.deliverySurcharge} &euro;</td>
            </tr>

            <tr class="lightBlue">
                <td colspan="2" id="totalCellLeft"><strong>Total</strong></td>
                <td id="totalCellRight"> ${commandeRecord.amount} &euro;</td>
            </tr>

            <tr class="lightBlue"><td colspan="3" style="padding: 0 20px"><hr></td></tr>

            <tr class="lightBlue">
                <td colspan="3" id="dateProcessedRow">Date traitée
                    ${commandeRecord.dateCreated}
                </td>
            </tr>
        </table>

    </div>

    <div class="summaryColumn" >

        <table id="deliveryAddressTable" class="detailsTable">
            <tr class="header">
                <th colspan="3">Adresse de livraison</th>
            </tr>

            <tr>
                <td colspan="3" class="lightBlue">
                    ${client.name}
                    <br>
                    ${client.address}
                    <hr>
                    <strong>Email:</strong> ${client.email}
                    <br>
                    <strong>Phone:</strong> ${client.phone}
                </td>
            </tr>
        </table>

    </div>
</div>