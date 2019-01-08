<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <title>List Directory</title>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    </head>
    <body>
        <center>
            <div ng-app="myApp" ng-controller="myController">
                <h1>Enter folder id or path to list the Directory:(Default RootID(/): 0)</h1>
                <input type="text" ng-model="in">
                <br /> <br />
                <button ng-click="getContents()">Submit</button>
                <div ng-repeat="x in contents">
                    <p ng-if="x.directory == true">
                        Folder : <a href="#" ng-click="get(x)">{{x.name}}</a>
                    </p>
                    <p ng-if="x.directory == false">
                        File : <a href="#" ng-click="download(x)">{{x.name}}</a>
                    </p>
                </div>
            </div>
        </center>
    </body>
    <script>
        var app = angular.module("myApp", []);
        app.controller("myController", function($scope, $http, $window) {
            $scope.getContents = function() {
                var temp = "/listDirectory";
                console.log($scope.in);
                $http({
                    url: temp,
                    method: "get",
                    dataType: "JSON",
                    params: {
                        input: $scope.in,
                    },
                }).then(function(response){
                    $scope.contents = response.data;
                });
            }

            $scope.get = function(x) {
                var temp = "/listDirectory";
                $http({
                    url: temp,
                    method: "get",
                    dataType: "JSON",
                    params: {
                        input: x.id,
                    },
                }).then(function(response){
                    $scope.contents = response.data;
                });
            }

            $scope.download = function(x) {
                var temp = "/downloadFile/" + x.id;
                $http({
                    url: temp,
                    method: "get",
                    dataType: "JSON",
                }).then(function(response){
                    console.log(response.data.cloudElementsLink);
                    $window.open(response.data.cloudElementsLink, '_blank');
                });
            }
        });
    </script>
</html>