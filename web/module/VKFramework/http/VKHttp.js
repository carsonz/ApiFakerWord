angular.module('VKHttp', [])
.factory('VKHttp', function($http,$q) {
    var server_interface = "posrecharge/posrechargeAction!";
    var server_domain = API.SERVER;
    var globalTimeout = 5000;
    var appid = '874287969';//苹果商店应用
    
    return {
        getAppID : function(){
            return appid;
        },
        postRequest : function(url,bodyjson) {
            var requestUrl = server_domain + url;
            console.log(requestUrl + JSON.stringify(bodyjson));
            return $http.post(requestUrl,bodyjson,{timeout:globalTimeout}).then(function(response){
                console.log("return success");
                return response.data;
            },
                function(response){
                    console.log("return failed");
                    return response.data;
                });
        },
        getRequest : function(url) {
            var requestUrl = server_domain + url;
            console.log(requestUrl);
            return $http.get(requestUrl,{timeout:globalTimeout}).then(function(response){
                console.log("return success:" + JSON.stringify(response.data));
                return response.data;
            },
                function(response){
                    console.log("return failed");
                    return response.data;
            });
         
         },
        getFullRequest : function(url,showLoading) {
            var requestUrl = url;
            console.log(requestUrl);
            return $http.get(requestUrl,{timeout:globalTimeout}).then(function(response){
                console.log("return success");
                return response.data;
            },
                function(response){
                    console.log("return failed");
                    return response.data;
                });
            
        }
         
         
         
         
         }
         });

