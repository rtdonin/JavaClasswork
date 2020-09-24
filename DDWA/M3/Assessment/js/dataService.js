var DataService = function () {
    var self = this;

    self.getItems = function (callback, errorFunc) {
        $.ajax({
            type: 'GET',
            url: 'http://tsg-vending.herokuapp.com/items',
            success: callback,
            error: errorFunc
        });
    }

    self.vendItem = function (amount, id, callback, errorFunc) {
        $.ajax({
            type: 'POST',
            url: 'http://tsg-vending.herokuapp.com/money/'
                + amount + '/item/' + id,
            success: callback,
            error: errorFunc
        })
    }
}