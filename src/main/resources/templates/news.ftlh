<!DOCTYPE html>
<html>
<head>
    <title>News Feed</title>
</head>
<body>
<h1>News Feed</h1><hr>

<!-- Form to specify the number of news items to display -->
<form action="/" method="get">
    <label for="count">Number of News Items:</label>
    <input type="number" name="count" id="count" value="${count!10}" min="10" max="50">
    <button type="submit">Show News</button>
</form>

<h4>Latest News</h4>

<!-- News container to display a list of news items -->
<div id="newsContainer">
    <!-- Check if there are news items to display -->
    <#if news??>
        <!-- Loop through the list of news items -->
        <#list news[0..count - 1] as new>
            <div class="newsItem">
                <!-- Display news details -->
                <p><b>${new.title}</b><br>
                    <b>${new.publicationDate}</b><br>
                    ${new.body}<br>
                    <!-- Link to view more details about the news item -->
                    <a href="/news/${new.id}">Read More...</a>
                </p>
            </div>
        </#list>
        <!-- If there are no news items to display -->
    <#else>
        <h3>No news available</h3>
    </#if>
</div>
<hr>

<h3>Create News</h3>

<!-- Form to create a new news item -->
<form action="/news/create" method="post" enctype="multipart/form-data">
    <!-- Input fields for title, body, and image -->
    Title:<input type="text" name="title"/><br><br>
    Body: <input type="text" name="body"/><br><br>
    Image: <input type="file" name="file1"/><br><br>
    <!-- Submit button to add a new news item -->
    <input type="submit" value="Add News"/>
</form>

</body>
</html>
