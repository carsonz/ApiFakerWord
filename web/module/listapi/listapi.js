/**
 * Created by cailiang on 16/9/9.
 */
angular.module('listapi', [])
    .controller('listapi', function($window,$rootScope,$state,$scope,$stateParams,Project) {
        {
            $rootScope.navtitle = "接口列表";

            $rootScope.lefttitle = "返回";
            $rootScope.leftclick = function () {
                $window.history.back();
            }

            $rootScope.righttitle = "添加接口";
            $rootScope.rightclick = function () {
                $state.go('nav.apidetail',{item:$stateParams.item});
            }
        }

        $scope.proj = JSON.parse($stateParams.item);

        //点击列表项，添加历史记录，并跳转到详情页面
        $scope.showDetail = function(item)
        {
            $state.go('nav.apidetail',{item:JSON.stringify(item)});
        }
        $scope.refresh = function()
        {
            //搜索列表
            Project.getApiList($scope.proj.projectName,$scope.proj.categoryName).then(function(response)
            {
                console.log('' + response);
                $scope.items = response.result;
            });
        }

        //点击删除处理
        $scope.delete = function(item,event)
        {
            var value = confirm("确认删除 " + item.apiName + " ?");
            event.stopPropagation();
            if (value == false){
                return;
            }
            Project.delApi(item).then(function(response)
            {
                $scope.refresh();
            });
        }
        $scope.refresh();
    });