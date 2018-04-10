<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Student</title>
    <link rel="stylesheet"
          type="text/css"
          href="<s:url value="/resources/bootstrap.min.css" />">
    <style>
        span.error {
            background-color: #ffcccc;
            border: 2px solid red;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="page-header" style="background-color: #66afe9;margin: 0px !important;">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3 text-center text-capitalize" style=""><h1><b>Spring MVC + Gradle
                Demo</b></h1></div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <h3 class="text-center"><s:message code="create.studentCommand"/></h3>
            <form method="post" class="form-horizontal">
                <div class="col-lg-6 col-lg-offset-3">
                    <fieldset>
                        <label class="text-left control-label" for="firstName">First Name</label>
                        <input class="pull-right form-control input-md" name="firstName" id="firstName"
                               placeholder="Enter first Name"/>
                        <errors name="firstName" class="error"/>
                        <br>
                    </fieldset>

                    <fieldset>
                        <label class="text-left control-label" for="lastName">Last Name</label>
                        <input class="pull-right form-control input-md" name="lastName" id="lastName"
                               placeholder="Enter last Name"/>
                        <errors name="lastName" class="error"/>
                        <br>
                    </fieldset>

                    <fieldset>
                        <label class="text-left control-label" for="emailAddress">Email Address</label>
                        <input class="pull-right form-control input-md" name="emailAddress" id="emailAddress"
                               placeholder="Enter email address"/>
                        <errors name="emailAddress" class="error"/>
                        <br>
                    </fieldset>
                    <fieldset>
                        <br>
                        <div class="row">
                            <div class="col-lg-6 col-lg-offset-3">
                                <div class="pull-left">
                                    <input type="submit" value="Create" class="btn btn-success ">
                                </div>
                                <div class="pull-right">
                                    &nbsp;<a class="btn btn-info" href="<s:url value="/student/list"/>">Back</a>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>