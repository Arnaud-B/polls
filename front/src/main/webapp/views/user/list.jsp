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
    <title>Liste des rédacteurs</title>
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
                    <h3 class="blue-text">Liste des rédacteurs</h3>
                    <table class="responsive-table">
                        <thead>
                            <tr>
                                <th>Pseudo</th>
                                <th>Âge</th>
                                <th>Mot de passe</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><input class="validate" disabled="" value="Toto" type="text" title="Pseudo"></td>
                                <td><input class="validate" disabled="" value="25" type="text" title="Âge"></td>
                                <td><input class="validate" disabled="" value="Toto" type="password" title="Pseudo"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><input class="validate" disabled="" value="Toto" type="text" title="Pseudo"></td>
                                <td><input class="validate" disabled="" value="25" type="text" title="Âge"></td>
                                <td><input class="validate" disabled="" value="Toto" type="password" title="Pseudo"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><input class="validate" disabled="" value="Toto" type="text" title="Pseudo"></td>
                                <td><input class="validate" disabled="" value="25" type="text" title="Âge"></td>
                                <td><input class="validate" disabled="" value="Toto" type="password" title="Pseudo"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><input class="validate" disabled="" value="Toto" type="text" title="Pseudo"></td>
                                <td><input class="validate" disabled="" value="25" type="text" title="Âge"></td>
                                <td><input class="validate" disabled="" value="Toto" type="password" title="Pseudo"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><input class="validate" disabled="" value="Toto" type="text" title="Pseudo"></td>
                                <td><input class="validate" disabled="" value="25" type="text" title="Âge"></td>
                                <td><input class="validate" disabled="" value="Toto" type="password" title="Pseudo"></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
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
