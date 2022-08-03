<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete article</title>
</head>
<body>
<a href="<c:url value="/article/list"/>">wstecz</a>

<form:form method="post" modelAttribute="article">
    <table>
        <tr>
            Czy jesteś pewny, że chcesz usunąć artykuł:
        </tr>
    </table>
    <table>
        <tr>
            <th>Tytuł</th>
            <th>Data dodania</th>
        </tr>
        <tr>
            <td>${article.title}</td>
            <td>${article.created}</td>
    </table>
    <input type="submit" value="Usuń">
</form:form>

</body>
</html>

