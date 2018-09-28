<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guru Uploading File</title>
</head>
<body>
File: <br />
<form action="Update" method="post"  enctype="multipart/form-data">
  <input type="file" name="guru_file" size="50" />
   <!--  <input type="text" name="textinput" size="50" />-->
<br />
<input type="submit" value="Upload" />
</form>
</body>
</html>