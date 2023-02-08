angular.module('quiz', ['ngStorage']).controller('quizController', function ($scope, $http, $localStorage, $rootScope) {
    const quizContextPath = 'http://localhost:8080/api/quiz'
    const answerContextPath = 'http://localhost:8080/api/answers'

    $localStorage.answer = [];
    $scope.i = 0;

    $scope.loadQuiz = function () {
        $http.get(quizContextPath)
            .then(function (response) {
                $scope.quiz = response.data;
                $scope.quantity = response.data.length;
            });
    };

    $scope.nextQuestion = function (i) {
        $scope.i = i + 1;
        let btn = angular.element(document.getElementById('btn'));
        if ($scope.i === $scope.quantity - 1) {
            btn.text("Finish");
        }

        let checkbox = angular.element(document.getElementsByName('checked'));
        let obj = {
            id: $scope.quiz[i].id,
            answers: []
        };

        for (let j = 0; j < checkbox.length; j++) {
            if (checkbox[j].checked) {
                obj.answers.push(checkbox[j].value);
            }
        }

        $localStorage.answer.push(obj);
        if ($localStorage.answer.length === $scope.quantity) {
            btn.text("Get report");
            $scope.getReport($localStorage.answer);
        }

    }

    $scope.getReport = function (answers) {
        $http.post(answerContextPath, answers)
            .then(function (response) {
                console.log(response);
            });

    }
    $scope.getResult = function (answers) {

    }
    $scope.loadQuiz();

});