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
    <title>Index de Polls</title>
    <jsp:include page="import_css.jsp"/>
    <link href="<c:url value="/resources/css/theme.css" />" rel="stylesheet">

</head>
<body class="grey lighten-4">
<main>
    <jsp:include page="sidebar.jsp"/>
    <div class="row">

    </div>
</main>
<%--<jsp:include page="footer.jsp"/>--%>
<jsp:include page="import_js.jsp"/>
<script src="<c:url value="/resources/js/theme.js"/>" type="text/javascript"></script>
</body>
</html>
