<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Students</title>
    <link rel="stylesheet"
          type="text/css"
          href="<s:url value="/resources/bootstrap.min.css" />">
</head>
<body>
<div class="container-fluid">
    <div class="page-header" style="background-color: #66afe9;margin: 0px !important;">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3 text-center text-capitalize" style=""><h1><b>Spring MVC + Gradle
                Demo</b></h1></div>
        </div>
    </div>
    <c:if test="${studentList.isEmpty()}">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3">
                <div class="alert alert-danger">No Student Record's Found</div>
            </div>
        </div>
    </c:if>
    <c:if test="${!studentList.isEmpty()}">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3">
                <table class="table table-responsive">
                    <tr>
                        <th>Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email Address</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="student" items="${studentList}" varStatus="i">
                        <tr>
                            <td>${i.index +1 }</td>
                            <td>${student.getFirstName()}</td>
                            <td>${student.getLastName()}</td>
                            <td>${student.getEmailAddress()}</td>
                            <td><a class="btn btn-success" href="<s:url value="edit?id=${student.getId()}"/>">Edit</a>
                            </td>
                            <td><a class="btn btn-danger"
                                   href="<s:url value="delete?id=${student.getId()}"/>">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </div>
    </c:if>

</div>
</body>
</html>
