/**
 * Created by cailiang on 16/9/9.
 */
angular.module("myApp", ['ui.router','ngAnimate','ngSanitize','controllers','factory','VKHttp'])
.config(function($stateProvider,$urlRouterProvider) {

    $stateProvider
        .state('nav', {
            url: '/nav',
            abstract: true,
            templateUrl: 'module/nav.html'
        })

        .state('nav.categorylist', {
            url: '/categorylist/:item',
            templateUrl: 'module/listcategory/_listcategory.html',
            controller: 'listcategory'
        })
        .state('nav.projectlist', {
            url: '/projectlist',
            templateUrl: 'module/listproject/_listproject.html',
            controller: 'listproject'
        })
        .state('nav.apilist', {
            url: '/apilist/:item',
            templateUrl: 'module/listapi/_listapi.html',
            controller: 'listapi'
        })
        .state('nav.apidetail', {
            url: '/apidetail/:item',
            templateUrl: 'module/apidetail/_apidetail.html',
            controller: 'apidetail'
        })


    $urlRouterProvider.otherwise('/nav/projectlist');
})
;