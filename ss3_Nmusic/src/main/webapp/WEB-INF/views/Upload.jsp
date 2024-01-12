<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: thanhngan
  Date: 9/26/2023
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h2>UpLoad</h2>
<form:form modelAttribute="newMusic" action="/music/create" method="post">
  ID: <form:input path="id"/> <br>
  Name: <form:input path="name" type="text"/> <br>
  Singer: <form:input path="singer" type="text"/> <br>

  Category: <form:select path="category" items="${category}"/> <br>
<%--  PATH: <form:input path="path"  id="p" type="text"/> <br>--%>
  Path: <input type="text" name="path" id="path" required/>
  <button type="submit" onclick="check()">UPLOAD</button>
</form:form>
<script>
  function check(){
    var path= document.getElementById("p").value;
    console.log(path)
    var dk1=".*\.mp3$";
    var dk2=".*\.wav$";
    var dk3=".*\.ogg$";
    var dk4=".*\.mp4$";
    if(!path.match(dk1)&& !path.match(dk2) && !path.match(dk3) && !path.match(dk4)){
      alert("Path is .mp3 or .mav")
      document.getElementById('p').value="";
    }
  }


</script>
</body>
</html>