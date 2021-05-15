angular.module('app', []).controller('BookController', function ($scope, $http) {

    $scope.books = [];

    $scope.authors = [];

    $scope.genres = [];

    $scope.currentBook = {
        errorMessage: null,
        invalidFields: null,
        data: {
            id: null,
            name: null,
            description: null,
            authorsIds: [],
            genresIds: []
        }
    }

    $scope.findAll = function () {
        findAll();
    }

    $scope.findById = function (id) {
        $http({
            method: 'GET',
            url: 'api/books/' + id
        }).then(function successCallback(response) {
            $scope.currentBook.data = response.data;
        })
    }

    $scope.add = function () {
        save('POST', 'api/books');
    }

    $scope.update = function () {
        save('PUT', 'api/books/' + $scope.currentBook.data.id);
    }

    $scope.deleteById = function (id) {
        $http({
            method: 'DELETE',
            url: 'api/books/' + id
        }).then(function successCallback() {
            findAll();
        });
    }

    $scope.resetForm = function () {
        resetForm();
    }

    $scope.clickOnAuthor = function (id) {
        let authorsIds = $scope.currentBook.data.authorsIds;
        if (_.includes(authorsIds, id)) {
            _.remove(authorsIds, function (item) {
                return item === id;
            });
            return;
        }
        authorsIds.push(id);
    }

    $scope.authorWasSelected = function (id) {
        return _.includes($scope.currentBook.data.authorsIds, id);
    }

    $scope.clickOnGenre = function (id) {
        let genresIds = $scope.currentBook.data.genresIds;
        if (_.includes(genresIds, id)) {
            _.remove(genresIds, function (item) {
                return item === id;
            });
            return;
        }
        genresIds.push(id);
    }

    $scope.genreWasSelected = function (id) {
        return _.includes($scope.currentBook.data.genresIds, id);
    }

    function init() {
        $http({
            method: 'GET',
            url: 'api/authors'
        }).then(function successCallback(response) {
            $scope.authors = response.data;
        });

        $http({
            method: 'GET',
            url: 'api/genres'
        }).then(function successCallback(response) {
            $scope.genres = response.data;
        });

        findAll();
    }

    function findAll() {
        $http({
            method: 'GET',
            url: 'api/books'
        }).then(function successCallback(response) {
            $scope.books = response.data;
        });
    }

    function save(method, url) {
        $http({
            method: method,
            url: url,
            data: $scope.currentBook.data
        }).then(function successCallback() {
            $("#bookModal").modal("hide");
            resetForm();
            findAll();
        }, function errorCallback(response) {
            $scope.currentBook.errorMessage = response.data.message;
            $scope.currentBook.invalidFields = response.data.invalidFields;
        });
    }

    function resetForm() {
        $scope.currentBook.data.id = null;
        $scope.currentBook.data.name = null;
        $scope.currentBook.data.description = null;

        $scope.currentBook.data.authorsIds = [];
        $scope.currentBook.data.genresIds = [];

        $scope.currentBook.invalidFields = null;
        $scope.currentBook.errorMessage = null;

        $(":checkbox").prop('checked', false).parent().removeClass('active');
    }

    init();

});