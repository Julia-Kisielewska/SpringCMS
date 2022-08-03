<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<body>
<a href="<c:url value="/article/add"/>">Dodaj atykuł</a>
<table>
    <tr>
<%--        <th></th>--%>
        <th>Tytuł</th>
        <th>Data dodania</th>
    </tr>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td>${article.title}</td>
            <td>${article.created}</td>

            <td>
                <a href="<c:url value="/article/delete?id=${article.id}"/>">usuń</a>
                <a href="<c:url value="/article/edit?id=${article.id}"/>">edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value="/article/author/list"/>">Autorzy</a>
<a href="<c:url value="/article/category/list"/>">Kategorie</a>
</body>
</body>
</html>
