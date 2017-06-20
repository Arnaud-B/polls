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
    <title>Connexion à Polls</title>
    <jsp:include page="../import_css.jsp"/>
</head>
<body class="grey lighten-4">
<div class="container">
    <div class="row" style="margin-top: 20%;">
        <div class="col s6 offset-s3">
            <div class="card z-depth-3">
                <div class="card-content">
                    <span class="card-title black-text">Polls</span>
                    <form action="/login/action/" method="post">
                        <div class="input-field">
                            <input placeholder="Pseudo" id="username" name="username" type="text" class="validate">
                            <label for="username">Pseudo</label>
                        </div>
                        <button class="btn blue waves-effect waves-light" type="submit" name="action">Suivant</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../import_js.jsp"/>
</body>
</html>
