<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<script src="js/jquery-1.8.3.min.js"></script>
<body>
<h1 align="center" style="color: green"><span id="username"></span>登陆成功</h1>
</body>
<script>
 $(function (){
   //从本地那token
var token=localStorage.getItem("token");
//如果没有token就说明他是第一次登录让他去登录页
if (token==null){
  alert("token不存在，请重新登录");
  $(location).attr('href',"/login.html");
  //如果不为空就让他验证一下
}else {
  $.ajax({
    url:"user/verifyToken",
    type:"post",
    data:{"token":token},
    success:function (resp){
      if (resp.success){
        $("#username").text(resp.data.username);
      }
      else {
        alert(resp.message);

        $(location).attr('href',"/login.html");
      }
    }
  })

}
 })
</script>
</html>