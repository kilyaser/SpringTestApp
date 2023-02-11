angular.module('quiz', ['ngStorage']).controller('reportController', function ($scope, $http, $localStorage) {
    const reportContextPath = 'http://localhost:8080/api/report'
    $scope.getReport = function () {
        $http.post(reportContextPath, $localStorage.answer)
            .then(function (response) {
               console.log(response);
               $scope.report = response.data;
            });
    }
    $scope.getReport();

});