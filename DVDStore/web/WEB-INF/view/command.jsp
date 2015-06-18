

<div id="singleColumn">

    <div class="summaryColumn" >

        <table id="orderSummaryTable" class="detailsTable">
            <tr class="header">
                <th colspan="3">Commande ${commandeRecord.id}</th>
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
                <td colspan="2" id="deliverySurchargeCellLeft">Livraison</td>
                <td id="deliverySurchargeCellRight"> ${initParam.deliverySurcharge} &euro;</td>
            </tr>

            <tr class="lightBlue">
                <td colspan="2" id="totalCellLeft"><strong>Total</strong></td>
                <td id="totalCellRight"> ${commandeRecord.amount} &euro;</td>
            </tr>

            <tr class="lightBlue"><td colspan="3" style="padding: 0 20px"><hr></td></tr>

            <tr class="lightBlue">
                <td colspan="3" id="dateProcessedRow">
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
                <td colspan="3"  class="lightBlue"> 
                    Nom : <strong> ${client.name} </strong>
                     <br>
                   
                    Addresse : <strong>${client.address}</strong>
                   <br>
                    Email : ${client.email}
                    <br>
                    Phone : ${client.phone}
                    <br>
                </td>
            </tr>
        </table>

    </div>
</div>