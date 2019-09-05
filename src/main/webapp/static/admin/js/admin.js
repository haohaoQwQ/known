/*
//得到项目根路径
function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
}

//清空新建用户窗口中的数据
/*function clearstudent() {
    $("#new_loginName").val("");
    $("#new_loginPwd").val("");
    $("#new_gender").val("");
    $("#new_telephone").val("");
}*/