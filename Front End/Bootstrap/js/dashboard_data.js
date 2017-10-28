/*global angular */
var usersApp = angular.module('usersApp', ['ngRoute']);
usersApp.controller('usersListCrtl', function ($scope, $http) {
    "use strict";
    
    var userData = {
            "user_id": "hbarthol@stevens.edu",
            "password": "12345",
            "create_date": "3/25/2017",
            "name": "Central Syria",
            "age": 20
        };
        
    $scope.user_name = userData["name"]

	//});
});
