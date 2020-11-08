<%--
  Created by IntelliJ IDEA.
  User: 19047589
  Date: 2020/10/13
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
      function test() {
          $.ajax({
              url: "testAjax/1001",
              type: "get",
              data:{id:1001},
              dataType:"jason",
              success:function (obj) {
                  alert(obj);
              }
          });
      }
    </script>
  </head>
  <body>
  <a href="/testREST/1001">测试Get</a>
  <hr/>
  <form action="/testREST" method="post">
    <input type="submit" value="测试Post">
  </form>
  <hr/>
  <form action="/testREST" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="测试PUT">
  </form>
  <hr/>
  <form action="/testREST/1001" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="测试DELETE">
  </form>
  <hr/>
  <input type="button" value="测试AJAX" onclick="test()">
  </body>
</html>
