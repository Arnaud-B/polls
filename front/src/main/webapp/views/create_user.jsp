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
    <title>Création d'un rédacteur</title>
    <jsp:include page="import_css.jsp"/>
    <link href="<c:url value="/resources/css/theme.css" />" rel="stylesheet">

</head>
<body class="grey lighten-4">
<main>
    <jsp:include page="sidebar.jsp"/>
    <div class="row">
        <div class="col s8 offset-s3">
            <div class="card">
                <div class="card-content">
                    <h3 class="blue-text">Créer un rédacteur</h3>
                    <form action="/create/user" method="post" style="margin-top: 50px;">
                        <div class="input-field">
                            <div class="input-field">
                                <input placeholder="Pseudo" id="pseudo" name="pseudo" type="text" class="validate">
                                <label for="pseudo">Pseudo</label>
                            </div>
                            <div class="input-field">
                                <input placeholder="Âge" id="age" type="text" name="age" class="validate" pattern="{0-9}">
                                <label for="age">Âge</label>
                            </div>
                            <div class="input-field">
                                <input placeholder="Mot de passe" id="password" name="password" type="password" class="validate">
                                <label for="password">Mot de passe</label>
                            </div>
                            <div class="center-align">
                                <button class="btn blue waves-effect waves-light" type="submit" name="action">Créer</button>
                                <button class="btn red waves-effect waves-light" type="reset" name="action">Annuler</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
<%--<jsp:include page="footer.jsp"/>--%>
<jsp:include page="import_js.jsp"/>
<script src="<c:url value="/resources/js/theme.js"/>" type="text/javascript"></script>
</body>
</html>
