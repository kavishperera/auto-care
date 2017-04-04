(function () {
    angular.module("appModule")
            .factory("ItemSelectionModelFactory", function () {
                var factory = {};

                factory.newData = function () {
                    var data = {
                        "indexNo": null,
                        "packageItem": null,
                        "itemUnit": null,
                        "quantity": null,
                        "price": null,
                        "value": null,
                        "orderStatus": "PENDING",
                        "jobStatus": "PENDING",
                        "formCustomer": true,
                        "jobCard": null,
                        "item": null
                    };
                    return data;
                };

                factory.newJobCardData = function () {
                    var data = {
                        "indexNo": 0,
                        "number": null,
                        "branch": null,
                        "date": null,
                        "transaction": null,
                        "priceCategory": null,
                        "inTime": null,
                        "outTime": null,
                        "inMileage": null,
                        "nextMileage": null,
                        "status": null,
                        "bay": null,
                        "client": null,
                        "vehicle": null
                    };
                    return data;
                };

                return factory;
            });
}());
