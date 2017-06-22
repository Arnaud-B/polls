<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="entities.User"%>
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
                        <form id="form" action="<c:url value='/login.do'/>" method="POST">
                            <%User user = ((User)request.getAttribute("user"));
                            String error  = (String) request.getAttribute("error");%>
                            <c:if test="${user_exist==false}">
                                <div class="input-field">
                                    <input placeholder="Âge" id="age" name="age" type="text" class="validate" pattern="{0-9}">
                                    <label for="age">Âge</label>
                                </div>
                                <input hidden type="password" name="password" value="" />
                                <input hidden type="text" name="username" value="${username}">
                            </c:if>
                            <%if(user != null){%>
                            <input hidden type="text" name="username" value="<%=user.getUsername()%>" />
                            <%if(user.getRoles() != null && user.getRoles().get(0).getRoleId() > User.ROLE_USER){%>
                                <div class="input-field">
                                    <input placeholder="password" id="password" name="password" type="password" class="validate">
                                    <label for="password">Password</label>
                                </div>
                                <input hidden type="text" name="age" value="<%=user.getAge()%>" />
                               <%}
                            }%>
                            <button class="btn blue waves-effect waves-light" type="submit" name="action">Suivant</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../import_js.jsp"/>
    <script>
        <%if(error != null){%>
        Materialize.toast('<%=error%>', 4000) // 4000 is the duration of the toast
        <%}%>
    </script>
</body>
</html>
