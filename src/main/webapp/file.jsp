<%--
  Created by IntelliJ IDEA.
  User: 19047589
  Date: 2020/10/13
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>

  <hr/>
  <form action="upload" method="post" enctype="multipart/form-data">
    上传：<input type="file" name="uploadFile">
    描述：<input type="text" name="desc">
    <input type="submit" value="上传">
  </form>
  </body>
</html>
