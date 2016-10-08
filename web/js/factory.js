/**
 * Created by cailiang on 16/9/9.
 */
angular.module('factory', [])
.factory('Project', function(VKHttp) {
    return {
        //获取项目
        getProjList : function () {
            var requestUrl = "projlist";
            return VKHttp.getRequest(requestUrl).then(function (response) {
                return response;
            });

        },
        addProjList : function (projname) {
            var requestUrl = "projadd";
            var body = {
                projectName:projname
            }
            return VKHttp.postRequest(requestUrl,body).then(function (response) {
                return response;
            });

        },
        delProject : function (projname) {
            var requestUrl = "projdel";
            var body = {
                projectName:projname
            }
            return VKHttp.postRequest(requestUrl,body).then(function (response) {
                return response;
            });

        },
        //获取分类
        getCateList : function (projname) {
            var requestUrl = "categorylist";
            var body = {
                projectName:projname
            }
            return VKHttp.postRequest(requestUrl,body).then(function (response) {
                return response;
            });

        },
        addCateList : function (projname,catename) {
            var requestUrl = "categoryadd";
            var body = {
                projectName:projname,
                categoryName:catename
            }
            return VKHttp.postRequest(requestUrl,body).then(function (response) {
                return response;
            });

        },
        delCategory : function (projname,catename) {
            var requestUrl = "categorydel";
            var body = {
                projectName:projname,
                categoryName:catename
            }
            return VKHttp.postRequest(requestUrl,body).then(function (response) {
                return response;
            });

        },
        getApiList : function (projname,catename) {
            var requestUrl = "apilist";
            var body = {
                projectName:projname,
                categoryName:catename
            }
            return VKHttp.postRequest(requestUrl,body).then(function (response) {
                return response;
            });

        },
        addApi : function (item) {
            var requestUrl = "apiadd";
            return VKHttp.postRequest(requestUrl,item).then(function (response) {
                return response;
            });
        },
        delApi : function (item) {
            var requestUrl = "apidel";
            return VKHttp.postRequest(requestUrl,item).then(function (response) {
                return response;
            });
        },
        updateApi : function (item) {
            var requestUrl = "apiupdate";
            return VKHttp.postRequest(requestUrl,item).then(function (response) {
                return response;
            });
        }
    }
});
