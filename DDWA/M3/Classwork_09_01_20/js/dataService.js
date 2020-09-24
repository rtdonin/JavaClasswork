var DataService = function () {
    var self = this;
    let counter = 2;
    let dvdList = [
        {
            dvdId: 1,
            title: 'Crossroads',
            releaseYear: '1986',
            director: 'Walter Hill',
            rating: 'R'
        }
    ];
    // //////////////////////////////////////////////////////////////////
    // Data manipulation methods
    self.getDvds = function() {
        return dvdList;
    }
    self.addDvd = function(dvd){
        dvd.dvdId = counter++;
        dvdList.push(dvd);
    }
    self.removeDvd = function (dvdId) {
        let tempList = [];
        for (let i = 0; i < dvdList.length; i++) {
            const dvd = dvdList[i];
            if (dvd.dvdId != dvdId) {
                tempList.push(dvd);
            }
        }
        dvdList = tempList;
    }
    self.getDvdById = function (dvdId) {
        for (let i = 0; i < dvdList.length; i++) {
            const dvd = dvdList[i];
            if (dvd.dvdId == dvdId) {
                return dvd;
            }
        }
        return null;
    }
    self.updateDvd = function (dvd) {
        for (let i = 0; i < dvdList.length; i++) {
            if (dvd.dvdId == dvdList[i].dvdId) {
                dvdList[i] = dvd;
            }
        }
    }
}
