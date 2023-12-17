<!DOCTYPE html>
<html>
<head>
    <title>News Feed</title>
</head>
<body>
<h1>News Feed</h1>
<hr>

<!-- Display images associated with the news item -->
<h4>Images</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
</#list>

<!-- Display details of the news item -->
<b>News Title: </b>${news.title}<br>
<b>Publication Date: </b>${news.publicationDate}<br>
<b>News Content: </b>${news.body}<br>
<hr>

<!-- Form to delete the news item -->
<form action="/news/delete/${news.id}" method="post">
    <input type="submit" value="Delete News"/>
</form>

</body>
</html>
