<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <link href="/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>Blog Starter</h1>
    <#list posts as post>
    <div class="post">
        <h2>${post.title}</h2>
        <p>${post.description}</p>
    </div>
    </#list>
</body>
</html>