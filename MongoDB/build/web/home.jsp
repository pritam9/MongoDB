<%-- 
    Document   : home
    Created on : Feb 22, 2017, 11:06:37 PM
    Author     : Pritam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="MainController" method="post">
            <label> Task : </label> <input type="text" name="todotext">
            <label> Priority : </label> <input type="text" name="priority">
            <label> Description : </label> <input type="text" name="description">
            <input type="hidden" name="action" value="insert">
            <input type="submit" value="Add New Task">
        </form>
        <div>
            <table sortable="true" style="border: 1px solid black; width: 100%">
                <thead>
                <th style="border: 1px solid black">Task</th>
                <th style="border: 1px solid black">Priority</th>
                <th style="border: 1px solid black">Description</th>
                
                <th style="border: 1px solid black"></th>
                </thead>
                <tbody>
                    <c:forEach var="todo" items="${todo}">
                        <tr>
                            <td style="border: 1px solid black">${todo.get("task")}</td>
                            <td style="border: 1px solid black">${todo.get("priority")}</td>
                            <td style="border: 1px solid black">${todo.get("description")}</td>
                            <td style="border: 1px solid black"><a href="MainController?action=delete&task_id=${todo.get("_id")}">Delete!!</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
