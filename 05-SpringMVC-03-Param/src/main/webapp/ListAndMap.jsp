<%--
  Created by IntelliJ IDEA.
  User: 86158
  Date: 2022/3/22
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试List和Map</title>
</head>
<body>
<form method="post" action="/user/ListAndMap">
    <table align="center">
        <caption><h1>注册</h1></caption>

        <tr>
            <td>用户名</td>
            <td><input type="text" name="list[0].username"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="list[0].password"></td>
        </tr>


        <tr>
            <td>姓名</td>
            <td><input type="text" name="map[user2].name"/></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="map[user2].age"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                男 <input type="radio" name="map[user2].gender" value="男">
                女 <input  checked type="radio"  name="map[user4].gender" value="女">
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="date" name="map[user2].birthday"/></td>
        </tr>
        <tr>
            <td>信息</td>
            <td><input type="text" name="map[user2].info"></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="reset" value="重置">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
