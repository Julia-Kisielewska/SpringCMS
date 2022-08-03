<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>
<a href="<c:url value="/author/add"/>">Dodaj autora</a>
<table>
    <tr>
        <th>Imię</th>
        <th>Nazwisko</th>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>

            <td>
                <a href="<c:url value="/author/delete?id=${author.id}"/>">usuń</a>
                <a href="<c:url value="/author/edit?id=${author.id}"/>">edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
