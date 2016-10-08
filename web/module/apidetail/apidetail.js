/**
 * Created by cailiang on 16/9/9.
 */
angular.module('apidetail', [])
    .controller('apidetail', function($window,$rootScope,$state,$scope,$stateParams,$timeout,Project) {
        {
            $rootScope.navtitle = "接口详情";

            $rootScope.lefttitle = "返回";
            $rootScope.leftclick = function () {
                $window.history.back();
            }

            $rootScope.righttitle = "修改";
            $rootScope.rightclick = function () {
                $rootScope.righttitle = "保存";
                //打开编辑权限
                changeEditState(true);
                $scope.store();
                //
                //if("修改" == $rootScope.righttitle){
                //    $rootScope.righttitle = "保存";
                //    //打开编辑权限
                //    changeEditState(true);
                //    //alert("进入编辑模式,编辑完成后请点击保存!");
                //}else{
                //    $rootScope.righttitle = "修改";
                //    //保存并恢复浏览权限
                //    changeEditState(false);
                //    //判断值
                //    $scope.store();
                //}
            }
        }
        var parent = $stateParams.item;
        $scope.proj = JSON.parse(parent);
        $scope.model = {
            url:"",
            forwardUrl:"",
            apiState:0,
            requestJson:"",
            responseJson:"",
            requestIntroMap:[],
            responseIntroMap:[],
            apiName:"",
            apiId:"",
            categoryName:"",
            projectName:""
        }
        $scope.model.categoryName = $scope.proj.categoryName;
        $scope.model.projectName = $scope.proj.projectName;
        $scope.editable = true;
        if ($scope.proj.apiId != null)
        {
            $scope.model.apiName = $scope.proj.apiName;
            $scope.model.apiId = $scope.proj.apiId;
            $scope.model.apiState = $scope.proj.apiState;
            $scope.model.requestJson = $scope.proj.requestJson;
            $scope.model.responseJson = $scope.proj.responseJson;
            $scope.model.requestIntroMap = $scope.proj.requestIntroMap == null? []: $scope.proj.requestIntroMap;
            $scope.model.responseIntroMap = $scope.proj.responseIntroMap == null? []: $scope.proj.responseIntroMap;
            $scope.model.url = $scope.proj.url;
            $scope.model.forwardUrl = $scope.proj.forwardUrl;
        }

        //状态修改模块
        {
            $scope.stateValue = [
                {value:"模拟",state:0},
                {value:"转发",state:1}
            ]
            var current = $scope.model.apiState;
            $scope.stateUrl = $scope.stateValue[current];

            $scope.updateState = function(state)
            {
                $scope.model.apiState = state.state;
            }
        }

        var changeEditState = function(editenable)
        {
            if (editenable)
            {
                _T('name_input').removeAttribute("readOnly");
                _T('url_input').removeAttribute("readOnly");
                _T('forward_input').removeAttribute("readOnly");
                _T('reqbody').removeAttribute("readOnly");
                _T('respbody').removeAttribute("readOnly");
                _T('state_select').removeAttribute("disabled");
                _T('reqbody').style.background = "#fff";
                _T('respbody').style.background = "#fff";
                _T('url_input').style.background = "#fff";
                _T('forward_input').style.background = "#fff";
                _T('name_input').style.background = "#fff";
                $rootScope.righttitle = "保存";
            }else{
                _T('name_input').setAttribute("readOnly","true");
                _T('url_input').setAttribute("readOnly","true");
                _T('forward_input').setAttribute("readOnly","true");
                _T('reqbody').setAttribute("readOnly","true");
                _T('respbody').setAttribute("readOnly","true");
                _T('state_select').setAttribute("disabled","true");
                _T('reqbody').style.background = "#f1f1f1";
                _T('respbody').style.background = "#f1f1f1";
                _T('url_input').style.background = "#f1f1f1";
                _T('forward_input').style.background = "#f1f1f1";
                _T('name_input').style.background = "#f1f1f1";
                $rootScope.righttitle = "修改";
            }
            $scope.editable = editenable;
        }

        $scope.transRequest = function()
        {
            var json = document.getElementById("reqbody").value;
            if (json.length > 0){
                $scope.requestItems = [];
                var req = JSON.parse(json);
                for(var p in req){
                    if(req.hasOwnProperty(p)){
                        var note = "";
                        for (var i = 0; i < $scope.model.requestIntroMap.length;i++){
                            var n = $scope.model.requestIntroMap[i];
                            if (n.name == p){
                                note = n.intro;
                                break;
                            }
                        }
                        var intro = {
                            name:p,
                            intro:note
                        }
                        $scope.requestItems.push(intro);
                    }
                }
            }
        }
        $scope.transResp = function()
        {
            var json = document.getElementById("respbody").value;
            if (json.length > 0){
                $scope.respItems = [];
                var req = JSON.parse(json);
                for(var p in req){
                    if(req.hasOwnProperty(p)){
                        var note = "";
                        for (var i = 0; i < $scope.model.responseIntroMap.length;i++){
                            var n = $scope.model.responseIntroMap[i];
                            if (n.name == p){
                                note = n.intro;
                                break;
                            }
                        }
                        var intro = {
                            name:p,
                            intro:note
                        }
                        $scope.respItems.push(intro);
                    }
                }
            }
        }

        $timeout($scope.transRequest,200);
        $timeout($scope.transResp,200);
        changeEditState($scope.editable);


        //检查和保存
        {
            $scope.check = function()
            {
                if($scope.model.apiName.length == 0) return "请输入api名称";
                if($scope.model.url.length == 0) return "请输入url名称";
                return null;
            }

            $scope.store = function()
            {
                var checkRet = $scope.check();
                if(checkRet  != null){
                    alert(checkRet);
                    return;
                }
                $scope.model.requestIntroMap = $scope.requestItems;
                $scope.model.responseIntroMap = $scope.respItems;
                if ($scope.model.apiId != null && $scope.model.apiId.length > 0){
                    Project.updateApi($scope.model).then(function(response)
                    {
                        console.log('' + response);
                        if (response.errCode == '0'){
                            alert("修改成功");
                        }
                        else{
                            alert("修改失败");
                        }
                    });
                }else{
                    Project.addApi($scope.model).then(function(response)
                    {
                        console.log('' + response);
                        if (response.errCode == '0'){
                            $rootScope.leftclick();
                        }
                        else{
                            alert("添加失败");
                        }
                    });
                }
            }

        }
    });