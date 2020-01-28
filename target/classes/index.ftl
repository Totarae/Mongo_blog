<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <link href="/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>Blog Starter</h1>
    <a href="/add-post">
        <button type="button" class="btn btn-primary">Add Post</button>
    </a>
    <#list posts as post>
    <div class="post">
        <div class="post_header">
            <div class="author_avatar"></div>
            <span>${post.oth}</span>
            <ul>
                <li>Дата поста</li>
                <li>
                    <#if post.publish_date??>
                        ${post.publish_date?datetime?string('dd.MM.yyyy HH:mm')}
                    <#else>

                    </#if>
                </li>
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