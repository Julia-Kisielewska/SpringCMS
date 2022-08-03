<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<categoryhtml>
<head>
    <title>Add author</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <form:hidden path="id"/>
    Imię
    <form:input path="firstName"/>
    Nazwisko
    <form:input path="lastName"/>
    <input type="submit" value="Save">
</form:form>
</body>
</categoryhtml>