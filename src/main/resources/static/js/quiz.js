angular.module('quiz', ['ngStorage']).controller('quizController', function ($scope, $http, $localStorage, $rootScope, $interval) {
    const quizContextPath = 'http://localhost:8080/api/quiz'
    const answerContextPath = 'http://localhost:8080/api/answers'

    $localStorage.answer = [];
    $scope.i = 0;
    $localStorage.hasResult = false;

    $scope.loadQuiz = function () {
        $http.get(quizContextPath)
            .then(function (response) {
                $scope.quiz = response.data;
                $scope.quantity = response.data.length;
                $scope.second = $scope.quantity * 60;
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
            $scope.getResult($localStorage.answer);
        }
    }

    $scope.getResult = function (answers) {
        $http.post(answerContextPath, answers)
            .then(function (response) {
                $scope.result = response.data;
                $localStorage.hasResult = true;
            });

    }

    $rootScope.isResultGot = function () {
        if ($localStorage.hasResult) {
            return true;
        } else {
            return false;
        }
    }

    $scope.countDownTimer = function () {
        let time = $interval(function () {
            if ($scope.second > 0) {
                $scope.second = $scope.second - 1;
                $scope.m = Math.floor($scope.second / 60);
                $scope.s = $scope.second - ($scope.m * 60);

            } else  {
                $interval.cancel(time);
                $scope.getResult($localStorage.answer);
            }
        }, 1000);
    }

    $scope.countDownTimer();
    $scope.loadQuiz();

});