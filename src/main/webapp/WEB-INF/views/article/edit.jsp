<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add article</title>
</head>
<body>
<form:form method="post" modelAttribute="article">
    <form:hidden path="id"/>
    <form:hidden path="created"/>
    <form:hidden path="updated"/>
    Tytuł
    <form:input path="title"/>
    Treść
    <form:input path="content"/>
    Autor
    <form:select path="author" items="${authors}" itemValue="id" itemLabel="fullName"/>
    Kategoria
    <form:select path="categories" items="${categories}" itemValue="id" itemLabel="name" multiple="true"/>
    <input type="submit" value="Save">
</form:form>
</body>

</html>