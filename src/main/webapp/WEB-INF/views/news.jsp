<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Books Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Book List</h1>

<c:if test="${!empty listNews}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Title</th>
            <th width="120">Body</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listNews}" var="news">
            <tr>
                <td>${news.id}</td>
                <td><a href="/newsdata/${news.id}" target="_blank">${news.title}</a></td>
                <td>${news.body}</td>
                <td><a href="<c:url value='/edit/${news.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${news.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Book</h1>

<c:url var="addAction" value="/news/add"/>

<form:form action="${addAction}" commandName="news">
    <table>
        <c:if test="${!empty news.title}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="title">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="title"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="body">
                    <spring:message text="Body"/>
                </form:label>
            </td>
            <td>
                <form:input path="body"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty news.title}">
                    <input type="submit"
                           value="<spring:message text="Edit News"/>"/>
                </c:if>
                <c:if test="${empty news.title}">
                    <input type="submit"
                           value="<spring:message text="Add News"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>