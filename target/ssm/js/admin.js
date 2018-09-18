$(document).ready(function () {
    //显示用户名
    $("#userName").html(window.localStorage.getItem("admin_name"));

    //显示所有学生
    $("#showAllStudents").click(function () {
        //ajax请求
        $.ajax({
            //请求方式
            type: 'GET',
            //路径
            url: 'http://localhost:8080/student/showStudents',
            //传递的参数
            data: {},
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            //返回的数据类型
            dataType: "json",
            //回调函数 ,成功时返回的数据存在形参data里
            success: function(data){
                if (data.statu==100){
                    //拼写HTML代码
                    var HTML_CODE="";
                    for(var i=0;i<data.data.length;i++) {
                        HTML_CODE+=
                            "<tr><td>" + data.data[i].studentId + "</td>" +
                            "<td>" + data.data[i].studentName + "</td>" +
                            "<td>" + data.data[i].studentClassid + "</td></tr>"
                    }
                    $("#showStudentsTable").html(HTML_CODE);
                }else {
                    alert(data.msg);
                }
            },
            error: function(){
                alert("连接失败");
            }
        });
    });
});