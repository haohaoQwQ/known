//得到项目根路径
function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
}

//点击注册用户
$("#register_btn").click(function () {
    //发送Ajax请求注册用户
    var root=getRootPath();
    console.log($("#userRegisterModel form").serialize());
    $.ajax({
        url:root+"register",
        type:"POST",
        data:$("#userRegisterModel form").serialize(),
        success:function(result){
            if(result.code == 100){
                //员工修改成功；
                //1、关闭模态框
                $("#registerLogin").modal('hide');
                alert("注册成功！");
            }else{
                //显示失败信息
                alert(result);
            }
        }
    });
});

//重新加载验证码
function reloadCode() {
    var root=getRootPath();
    var time=new Date().getTime();
    document.getElementById("imagecode").src=root+"ImageServlet?d="+time;
}




