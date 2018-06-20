<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>上传视频</title>
</head>

<body>
	<form id="form1" action = "http://1090164.all123.net:8080/friendhelper/upload/fileupload" enctype="multipart/form-data" method="POST">
		<td>视频名称</td>
		<td><input type="text" name="title" value=""/></td>
		<br>
		<td>视频类别</td>
		<td><input type="text" name="group" value=""/></td>
		<br>
		<td>视频文件</td>
		<td><input type="file" name="file" value="file"/></td>
		<br>
		<td><input type="submit" value="上传"></td>
	</form>
</body>
</html>
