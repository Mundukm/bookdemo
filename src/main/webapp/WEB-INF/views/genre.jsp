<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form action="genre/add" method="post">
    Genre name:<input type="text" name="name">
    <br>
    <button type="submit">save</button>
</form>

<h2>All Genres</h2>
<c:forEach items="${genreList}" var="genre">

    <ul>
        <li>${genre.name} <a href="genre/delete/${genre.id}">del</a></li>
    </ul>

</c:forEach>

<a href="/"><h4>home</h4></a>