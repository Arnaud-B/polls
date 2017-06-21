<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Liste des sondages</title>
    <jsp:include page="../import_css.jsp"/>
    <link href="<c:url value="/resources/css/theme.css" />" rel="stylesheet">

</head>
<body class="grey lighten-4">
<main>
    <jsp:include page="../sidebar.jsp"/>
    <div class="row">
        <div class="col s8 offset-s3">
            <div class="card">
                <div class="card-content">
                    <form action="/session/answer/success/" method="POST" style="margin-top: 50px;">
                        <h3 class="blue-text">Sondage n°${session.id}</h3>

                        Name: ${session.name}/Question: ${session.question} <br/>
                        <input type="hidden" name="session_id" value="${session.id}" />
                        <c:forEach var="response" items="${responses}">
                            <div>
                                <input type="checkbox" value="${response.id}" id="response_${response.id}" name="responses_id" />
                                <label for="response_${response.id}">${response.label}</label>
                            </div>
                        </c:forEach>
                        <div class="center-align">
                            <button class="btn blue waves-effect waves-light" type="submit">Ajouter</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
<%--<jsp:include page="footer.jsp"/>--%>
<jsp:include page="../import_js.jsp"/>
<script src="<c:url value="/resources/js/theme.js"/>" type="text/javascript"></script>
</body>
</html>
