//得到项目根路径
function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
}

//点击注册用户
$("#register_btn").click(function () {
    //发送Ajax请求注册用户
    $.ajax({
        url:getRootPath()+"register",
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

//点击登录用户
$("#login_btn").click(function () {
    //发送Ajax请求登录用户
    $.ajax({
        url:getRootPath()+"login",
        type:"POST",
        data:$("#userLoginModel form").serialize(),
        success:function(result){
            if(result.code == 100){
                //1、关闭模态框
                $("#registerLogin").modal('hide');
                alert("登录成功！");
                window.location.href=getRootPath();
            }
            if (result.code==1) {
                //登录后台管理页面
                window.location.href=getRootPath()+"admin";
            }
            if(result.code==200){
                alert("用户名或密码输入有误!");
                window.location.href=getRootPath();
            }
            if (result.code==201){
                alert("验证码输入有误！");
                window.location.href=getRootPath();
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




