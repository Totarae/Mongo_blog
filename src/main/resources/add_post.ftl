<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <link href="/style.css" rel="stylesheet" type="text/css">
    <link href="/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Add Post</h1>
<form action="/new_post" method="post">
    <dl>
        <dt>Username:
        <dd><input type="text" name="username" size="30" maxlength="50" <#--value="${username!}"-->>
        <dt>Title:
        <dd><input type="text" name="title" size="30" maxlength="50" <#--value="${username!}"-->>
        <dt>Post:
        <dd><textarea name="post" cols="40" rows="3"></textarea>
    </dl>
    <div class="actions"><input type="submit" value="Post"></div>
</form>
</body>
</html>