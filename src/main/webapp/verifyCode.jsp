<%--
  Created by IntelliJ IDEA.
  User: huanli9
  Date: 2020/11/17
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
</head>
<body>
<div>
    <form id="codeForm">
        <div>
            <input type="text" name="phoneNumber" placeholder="填写手机号">
            <button type="button" id="sendCode">发送验证码</button>
            <font id="countDown" color="red"></font>
            <br>
            <input type="text" name="verifyCode" placeholder="填写验证码">
            <button type="button" id="verifyCode">确定</button>
            <font id="result" color="green"></font>
            <font id="error" color="red"></font>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">
    var t = 60;
    var internal;

    function refer() {
        $("#countDown").text("请于" + t + "秒内填写验证码"); //显示倒计时
        t--;
        if (t <= 0) {
            clearInterval(internal);
            $("#countDown").text("验证码已失效");
        }
    }

    $(function () {
        $("#sendCode").click(function () {
            $.post("getVerifyCode", $("#codeForm").serialize(), function (data) {
                if (data == "true") {
                    t = 60;
                    clearInterval(internal);
                    internal = setInterval("refer()", 1000); //启动1秒定时
                } else if (data == "limit") {
                    clearInterval(internal);
                    $("#countDown").text("单日发送超过次数！")
                }else if(data == "empty"){
                    clearInterval(internal);
                    $("#countDown").text("手机号码不能为空！")
                }
            });
        });
    })

    $(function () {
        $("#verifyCode").click(function () {
            $.post("verifyCode", $("#codeForm").serialize(), function (data) {
                if (data == "true") {
                    $("#result").attr("color","green");
                    $("#result").text("验证成功");
                    clearInterval(internal);
                    $("#countDown").text("")
                } else{
                    $("#result").attr("color","red");
                    $("#result").text("验证失败");
                }
            });
        });
    })
</script>
</html>
