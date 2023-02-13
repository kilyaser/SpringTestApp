angular.module('quiz', ['ngStorage']).controller('reportController', function ($scope, $http, $localStorage) {
    const reportContextPath = 'http://localhost:8080/api/report'
    $scope.getReport = function () {
        $http.post(reportContextPath, $localStorage.answer)
            .then(function (response) {
               $scope.report = response.data;
                if ($scope.report.reportItems.length === 0) {
                    $scope.textReport();
                }
            });
    }

    $scope.textReport = function () {
        let title = angular.element(document.getElementById('quiz-report'))
        title.text("No report, because you didn't answer any question");
    }

    $scope.getReport();

});