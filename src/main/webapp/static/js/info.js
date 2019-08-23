
//确认上传更新头像
function avatar() {
    $("form[name='avatarUpload']").submit();
}

function select() {
    return $('#avatar').click();
}

$(function () {
    $(".modify_button").click(function () {
        $("#ModifyModal").modal({
            backdrop: "static"
        });
    })


    $(".cc-profile-image").on('click', 'img', function () {
        select();
    });


    $("#avatar").change(function () {
        var filePath = $("#avatar").val();
        var fileType = filePath.substring(filePath.lastIndexOf("."));
        if (fileType == ".jpg" || fileType == ".png") {
            $(".img").attr("src", URL.createObjectURL($(this)[0].files[0]));
            $("#avatarModal").modal({
                backdrop: "static"
            });
        } else {
            var flag = confirm("上传图片格式不正确，请重新选择(.jpg或.png)");
        }
    });
})

//得到项目根路径
function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
}

$("#exitLogin").click(function () {
    window.location.href=getRootPath()+"exitLogin";
});

