$(document).ready(function () {

    //登录按钮的函数
    $("#login").click(function () {
        //获取账户
        var userId = $("#userId").val();
        //获取密码
        var userPassword = $("#userPassword").val();

        loginCheck(userId,userPassword);

        //清空文本框
        $("#userId").val("");
        $("#userPassword").val("");
    });

    function loginCheck(userId,userPassword) {

        //ajax请求
        $.ajax({
            //请求方式
            type: 'GET',
            //路径
            url: 'http://localhost:8080/user/loginCheck',
            //传递的参数
            data: {userId:userId,userPassword:userPassword},
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            //返回的数据类型
            dataType: "json",
            //回调函数 ,成功时返回的数据存在形参data里
            success: function(data){
                if (data.data.userRole == 1) {
                        var username = data.data.userName;
                        window.localStorage.setItem("admin_name", username);
                        window.location.href = "admin.html";
                    }
                else{
                    alert("登录成功！");
                }


            },
            error: function(){
                alert("连接失败");
            }
        });
    }
});

