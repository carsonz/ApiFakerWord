/**
 * Created by cailiang on 16/9/9.
 */
angular.module('listproject', [])
    .controller('listproject', function($rootScope,$scope,$state,Project) {

        {
            $rootScope.navtitle = "项目列表";

            $rootScope.lefttitle = "";
            $rootScope.leftclick = function () {
            }

            $rootScope.righttitle = "添加项目";
            $rootScope.rightclick = function () {
                var value = prompt("请输入项目名称","");
                if (value.length == null){
                    alert("请输入项目名称.");
                    return;
                }
                Project.addProjList(value).then(function(response)
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

        $scope.refresh = function()
        {
            //搜索列表
            Project.getProjList().then(function(response)
            {
                console.log('' + response);
                $scope.items = response.result;
            });
        }

        //点击列表项，添加历史记录，并跳转到详情页面
        $scope.showDetail = function(item)
        {
            //$state.go('tab.bus-detail',{item:item.bus_num});
            $state.go('nav.categorylist',{item:JSON.stringify(item)});
        }

        //点击删除处理
        $scope.delete = function(item,event)
        {
            var value = confirm("确认删除 " + item.projectName + " ?");
            event.stopPropagation();
            if (value == false){
                return;
            }
            //搜索列表
            Project.delProject(item.projectName).then(function(response)
            {
                $scope.refresh();
            });
        }


        $scope.refresh();
    });