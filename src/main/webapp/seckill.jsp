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
    <form id="secKillForm">
        <div>
            <button type="button" id="secKill" >秒杀</button>
            <input type="hidden" name="prodId" value="1001"/>
            <font id="tip" color="red"></font>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">

    $(function () {
        $("#secKill").click(function () {
            $.post("secKill", $("#secKillForm").serialize(), function (data) {
                if (data == false) {
                    $("#tip").text("抢光了！");
                    $("#secKill").attr("disabled",true);
                }
            });
        });
    })

</script>
</html>
