<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete category</title>
</head>
<body>
<a href="<c:url value="/category/list"/>">Lista kategorii</a>

<form:form method="post" modelAttribute="category">
    <table>
        <tr>
            Czy jesteś pewny, że chcesz usunąć kategorię:
        </tr>
    </table>
    <table>
        <tr>
            <th>Kategoria</th>
            <th>Opis</th>
        </tr>
        <tr>
            <td> ${category.name}</td>
            <td>${category.description}</td>
    </table>
    <input type="submit" value="Usuń">
</form:form>

</body>
</html>
