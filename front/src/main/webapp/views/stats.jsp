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
    <title>Statistiques</title>
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
                    <h3 class="blue-text">Liste des sondages sans réponses</h3>
                    <ul class="collection">
                        <li class="collection-item"><div>Sondage n°1<a href="/session/1" class="secondary-content"><i class="material-icons">send</i></a></div></li>
                        <li class="collection-item"><div>Sondage n°2<a href="/session/2" class="secondary-content"><i class="material-icons">send</i></a></div></li>
                        <li class="collection-item"><div>Sondage n°3<a href="/session/3" class="secondary-content"><i class="material-icons">send</i></a></div></li>
                        <li class="collection-item"><div>Sondage n°4<a href="/session/4" class="secondary-content"><i class="material-icons">send</i></a></div></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col s8 offset-s3">
            <div class="card">
                <div class="card-content">
                    <h3 class="blue-text">Histogrammes</h3>
                    <blockquote>
                        Choisissez un sondage pour afficher ses histogrammes.
                    </blockquote>
                    <form action="/stats" method="get" id="poll">
                        <div class="input-field">
                            <select name="id" form="poll">
                                <option value="" disabled selected>Sélectionnez un sondage</option>
                                <option class="blue-text" value="1">Sondage n°1</option>
                                <option class="blue-text" value="2">Sondage n°2</option>
                                <option class="blue-text" value="3">Sondage n°3</option>
                            </select>
                            <label>Sondage</label>
                            <button class="btn blue waves-effect waves-light" type="submit">Suivant</button>
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
