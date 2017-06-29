(function () {
    'use strict';

    var service = function (systemConfig, $http) {

        //load 
        this.loadCategory = function () {
            return $http.get(systemConfig.apiUrl + "/api/care-point/master/category");
        };

        this.loadItems = function () {
            return $http.get(systemConfig.apiUrl + "/api/care-point/master/item");
        };

        this.loadVehicles = function () {
            return $http.get(systemConfig.apiUrl + "/api/care-point/service/zmaster/vehicle");
        };

        this.loadItemUnits = function () {
            return $http.get(systemConfig.apiUrl + "/api/care-point/master/item-unit");
        };

        //load pending jobcards
        this.pendingJobCards = function () {
            return $http.get(systemConfig.apiUrl + "/api/care-point/transaction/job-card/get-pending-job-cards");
        };

        this.getPackageItems = function (indexNo) {
            return $http.get(systemConfig.apiUrl + "/api/care-point/master/package-item/get-package-items/" + indexNo);
        };

        this.saveJobItems = function (data) {
            return $http.post(systemConfig.apiUrl + "/api/care-point/transaction/job-item/save-job-items", data);
        };

        this.deleteJobItems = function (indexNo) {
            return $http.delete(systemConfig.apiUrl + "/api/care-point/transaction/job-item/delete-job-items/" + indexNo);
        };

        this.getJobItemHistory = function (indexNo) {
            return $http.get(systemConfig.apiUrl + "/api/care-point/transaction/job-item/find-by-job-card-items/" + indexNo);
        };

        this.findJobCard = function (indexNo) {
            return $http.get(systemConfig.apiUrl + "/api/care-point/transaction/job-card/get-job-card/" + indexNo);
        };

        this.findByCategoryAndPriceCategory = function (category, priceCategory) {
            return $http.get(systemConfig.apiUrl + "/api/care-point/master/item/find-item-by-category/" + category + "/" + priceCategory);
        };

        this.saveCustomerReceiveItem = function (customerReceiveItem) {
            return $http.post(systemConfig.apiUrl + "/api/care-point/transaction/client-received-item/save-client-received-item", customerReceiveItem);
        };

        this.deleteCustomerReceiveItem = function (indexNo) {
            return $http.delete(systemConfig.apiUrl + "/api/care-point/transaction/client-received-item/delete-client-received-item/" + indexNo);
        };

        this.findByJobCardCustomerReceiveItem = function (jobCard) {
            return $http.get(systemConfig.apiUrl + "/api/care-point/transaction/client-received-item/" + jobCard);
        };

        this.findByItemStockItmQty = function () {
            return $http.get(systemConfig.apiUrl + "/api/care-point/transaction/job-item/get-item-qty-by-stock");
        };

        this.setServiceChargers = function (jobCard, status) {
            return $http.get(systemConfig.apiUrl + "/api/care-point/transaction/job-card/service-charge/" + jobCard + "/" + status);
        };

        //job vehicle attenctions
        this.getVehicleAttenctionsCategory = function () {
            return $http.get(systemConfig.apiUrl + "/api/care-point/service/vehicle-attenctions/vehicle-attenctions-category");
        };

        this.getVehicleAttenctions = function () {
            return $http.get(systemConfig.apiUrl + "/api/care-point/service/vehicle-attenctions");
        };

        this.getSelectedVehicleAttenctionCategoryData = function (category, jobCard) {
            return $http.get(systemConfig.apiUrl + "/api/care-point/service/vehicle-attenctions/find-by-job-vehicle-attenctions-job-card/" + category + "/" + jobCard);
        };

        this.addJobVehicleAttenction = function (data) {
            return $http.post(systemConfig.apiUrl + "/api/care-point/service/vehicle-attenctions/save-job-vehicle-attenctions", data);
        };

        this.getLastJobCardVehicleAttenctions = function (vehicle) {
            return $http.get(systemConfig.apiUrl + "/api/care-point/service/vehicle-attenctions/find-last-job-card/" + vehicle);
        };
        
        this.findJobItemByIndexNo = function (jobItem) {
            return $http.get(systemConfig.apiUrl + "/api/care-point/transaction/job-item/find-item-by-index-no/" + jobItem);
        };


    };

    angular.module("appModule")
            .service("ItemSelectionService", service);
}());