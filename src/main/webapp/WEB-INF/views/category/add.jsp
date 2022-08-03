<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add category</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    <form:hidden path="id"/>
    Kategoria
    <form:input path="name"/>
    Opis
    <form:input path="description"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>