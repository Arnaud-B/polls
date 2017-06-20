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
                        <form action="/login/action/success/" method="post">
                            <c:if test="${user_exist==false}">
                                <div class="input-field">
                                    <input placeholder="Âge" id="age" name="age" type="text" class="validate" pattern="{0-9}">
                                    <label for="age">Âge</label>
                                </div>
                            </c:if>
                            <c:if test="${user_exist!=false}">
                                <div class="input-field">
                                    <input hidden placeholder="Âge" id="age" name="age" type="text" class="validate" pattern="{0-9}" value="0">
                                    <label hidden for="age">Âge</label>
                                </div>
                            </c:if>
                            <input hidden type="text" name="username" value="${username}" />
                            <div class="input-field">
                                <input placeholder="password" id="password" <c:if test="${wrong_password==true}">data-error=".errorTxt" aria-invalid="error" class="error" aria-describedby="password-error"</c:if> <c:if test="${wrong_password==false}">class="validate"</c:if> name="password" type="password" minlength="6">
                                <label for="password">Password</label>
                                <c:if test="${wrong_password==true}">
                                    <div class="errorTxt">
                                        <div id="password-error" class="error">
                                            Enter your password
                                        </div>
                                    </div>
                                </c:if>
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
