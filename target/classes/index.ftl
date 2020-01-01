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
        <div class="post_header">
            <div class="author_avatar"></div>
            <span>author_name</span>
            <ul>
                <li>Дата поста</li>
                <li>Время чтения</li>
            </ul>
        </div>
        <h2>${post.title}</h2>
        <p>${post.description}</p>
        <div class="post_stat">
            <span>Просмотров: 0</span>
            <a href=".">
                <span>Комментировать</span>
            </a>
        </div>
    </div>
    </#list>
</body>
</html>