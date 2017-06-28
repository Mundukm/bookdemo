<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="book/add" method="post">
    Book name:<input type="text" name="name">
    <br>
    Book genre:
    <select name="genreId" id="">
        <c:forEach items="${genreList}" var="genre">
            <option value="${genre.id}">${genre.name}</option>
        </c:forEach>
    </select>
    <br>
    <button type="submit">save</button>
</form>

<h2>All Books</h2>
<c:forEach items="${bookList}" var="book">

    <ul>
        <li>${book.name} ${book.genre.name} <a href="book/delete/${book.id}">del</a></li>
    </ul>

</c:forEach>

<a href="/"><h4>home</h4></a>