/*
Created by: Margaret Donin
Date created: 09/16/20
Date revised:
*/

var ds = new DataService();
var money = 0.0;

/*************************************
 * Formatting/ Getting Items
 *************************************/
function formatItemBox(item, i) {
    var itemFormatted = `<div id = '${item.id}' class = 'item col-lg-3 col-sm-4' data-i = '${i}' >
                            ${i}
                            <p class = 'text-center'>
                                ${item.name}<br />
                                $${item.price.toFixed(2)}<br />
                                Quantity Left: ${item.quantity}
                            </p>
                        </div>`;
    
    return itemFormatted;
}

function refreshItemTable(itemList) {
    $('#items').empty();
    var items = '';

    $(itemList).each(function (index, item) {
        items += formatItemBox(item, (index + 1));
    });

    $('#items').append(items);
}

function updatePage() {
    ds.getItems(refreshItemTable, handleGetItemsError);
}
/*************************************
 * Money Updating
 *************************************/
function updateMoney(money) {
    $('#money-added').val(money.toFixed(2));
}

function updateMessage(message) {
    $('#messages').val(message.responseJSON.message);
}

function updateChange(change) {
    money = 0;
    $('#messages').val(' ');
    $('#money-added').val((0.00).toFixed(2));
    $('#change').val(change);
}

function stringifyChange(coins) {
    var change = '';
    var coinName = ['Quarter', 'Dime', 'Nickle', 'Penny'];
    var coinAmount = [coins.quarters, coins.dimes, coins.nickles, coins.pennies];

    for (let i = 0; i < coinAmount.length; i++) {
        let amount = coinAmount[i];
        
        if (change.length > 1 && amount > 0) {
            change += ', ';
        }

        if (amount == 1) {
            change += amount + ' ' + coinName[i];
        } else if (amount > 1 && i != 3) {
            change += amount + ' ' + coinName[i] + 's';
        } else if (amount > 1) {
            change += amount + ' Pennies';
        }
    }

    money = 0;
    $('#messages').val('Thank you!');
    $('#change').val(change);
    
    updatePage();
}

/*************************************
 * Button Management
 *************************************/
function onAddDollarClicked(e) {
    e.preventDefault();
    money += 1.00;
    updateMoney(money);
}

function onAddQuarterClicked(e) {
    e.preventDefault();
    money += 0.25;
    updateMoney(money);
}

function onAddDimeClicked(e) {
    e.preventDefault();
    money += 0.10;
    updateMoney(money);
}

function onAddNickleClicked(e) {
    e.preventDefault();
    money += 0.05;
    updateMoney(money);
}

function onSelectItemClicked(e) {
    e.preventDefault();
    var item = $(this);
    var id = item.data('i');

    $('#hidden-value').val(item[0].id);
    $('#item-number').val(id);
}

function onPurchaseItemClicked(e) {
    e.preventDefault();
    var id = $('#hidden-value').val();
    ds.vendItem(money.toFixed(2), id, stringifyChange, updateMessage);

}

function onReturnChangeClicked(e) {
    e.preventDefault();
    var change = '';
    var toReturn = money;
    var value = [[.25, 'Quarter'], [0.10, 'Dime'], [0.05, 'Nickle']];

    for (let i = 0; i < value.length; i++) {
        denomination = value[i][0];
        amount = (toReturn - (toReturn % denomination)) / denomination;

        if (change.length > 1 && amount > 0) {
            change += ',';
        }

        if (amount == 1) {
            change += amount + ' ' + value[i][1] + ' ';
        } else if (amount > 1) {
            change += amount + ' ' + value[i][1] + 's ';
        }

        toReturn -= (amount * denomination);

    }

    updateChange(change);
}

/*************************************
 * Error Handling
 *************************************/
function handleGetItemsError(error) {
    updateMessage(error);
}

function handleVendItemError(error) {
    updateMessage(error);
}

/*************************************
 * Brain of the operation
 *************************************/
$(document).ready(function () {
    updatePage();

    $(document).on('click', '#add-dollar', onAddDollarClicked);
    $(document).on('click', '#add-quarter', onAddQuarterClicked);
    $(document).on('click', '#add-dime', onAddDimeClicked);
    $(document).on('click', '#add-nickle', onAddNickleClicked);
    $(document).on('click', '#make-purchase', onPurchaseItemClicked);
    $(document).on('click', '#items > div', onSelectItemClicked);
    $(document).on('click', '#change-return', onReturnChangeClicked);

});

            