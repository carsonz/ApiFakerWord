/**
 * Created by cailiang on 16/9/9.
 */
angular.module('listcategory', [])
    .controller('listcategory', function($window,$rootScope,$scope,$state,$stateParams,Project) {

        {
            $rootScope.navtitle = "分类列表";

            $rootScope.lefttitle = "返回";
            $rootScope.leftclick = function () {
                $window.history.back();
            }

            $rootScope.righttitle = "添加分类";
            $rootScope.rightclick = function () {
                var value = prompt("请输入分类名称","功能分类");
                if (value.length == null){
                    alert("请输入分类名称.");
                    return;
                }
                Project.addCateList($scope.proj.projectName,value).then(function(response)
                {
                    console.log('' + response);
                    if (response.errCode == '0'){
                        $scope.refresh();
                    }else{
                        alert("添加失败.");
                    }
                });
            }
        }

        $scope.proj = JSON.parse($stateParams.item);

        $scope.refresh = function()
        {
            //搜索列表
            Project.getCateList($scope.proj.projectName).then(function(response)
            {
                console.log('' + response);
                $scope.items = response.result;
            });
        }

        //点击列表项，添加历史记录，并跳转到详情页面
        $scope.showDetail = function(item)
        {
            //$state.go('tab.bus-detail',{item:item.bus_num});
            $state.go('nav.apilist',{item:JSON.stringify(item)});
        }

        //点击删除处理
        $scope.delete = function(item,event)
        {
            var value = confirm("确认删除 " + item.categoryName + " ?");
            event.stopPropagation();
            if (value == false){
                return;
            }
            Project.delCategory(item.projectName,item.categoryName).then(function(response)
            {
                $scope.refresh();
            });
        }


        $scope.refresh();
    });