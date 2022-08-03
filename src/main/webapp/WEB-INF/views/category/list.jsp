<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<a href="<c:url value="/category/add"/>">Dodaj kategorię</a>
<table>
    <tr>
        <th>Kategoria</th>
        <th>Opis</th>
    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.name}</td>
            <td>${category.description}</td>

            <td>
                <a href="<c:url value="/category/delete?id=${category.id}"/>">usuń</a>
                <a href="<c:url value="/category/edit?id=${category.id}"/>">edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
