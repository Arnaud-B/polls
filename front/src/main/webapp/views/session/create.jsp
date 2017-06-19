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
    <title>Création d'un sondage</title>
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
                    <h3 class="blue-text">Créer un sondage</h3>
                    <button class="btn-floating red waves-effect waves-light disabled right" id="removeButton" type="button" onclick="removeAnswer()"><i class="material-icons">remove</i></button>
                    <button class="btn-floating blue waves-effect waves-light right" id="addButton" type="button" onclick="addAnswer()"><i class="material-icons">add</i></button>
                    <form action="/session/create/success/" method="POST" style="margin-top: 50px;">
                        <div class="input-field">
                            <div class="input-field">
                                <input placeholder="Question" id="question" name="question" type="text" class="validate">
                                <label for="question">Question</label>
                            </div>
                            <div class="input-field">
                                <input placeholder="Réponse n°1" id="answer1" type="text" name="answer">
                                <label for="answer1">Réponse n°1</label>
                            </div>
                            <div class="input-field hiddendiv" id="div2">
                                <input placeholder="Réponse n°2" id="answer2" type="text" name="answer">
                                <label for="answer2">Réponse n°2</label>
                            </div>
                            <div class="input-field hiddendiv" id="div3">
                                <input placeholder="Réponse n°3" id="answer3" type="text" name="answer">
                                <label for="answer3">Réponse n°3</label>
                            </div>
                            <div class="input-field hiddendiv" id="div4">
                                <input placeholder="Réponse n°4" id="answer4" type="text" name="answer">
                                <label for="answer4">Réponse n°4</label>
                            </div>
                            <div class="input-field hiddendiv" id="div5">
                                <input placeholder="Réponse n°5" id="answer5" type="text" name="answer">
                                <label for="answer5">Réponse n°5</label>
                            </div>
                            <div class="input-field hiddendiv" id="div6">
                                <input placeholder="Réponse n°6" id="answer6" type="text" name="answer">
                                <label for="answer6">Réponse n°6</label>
                            </div>
                            <div class="input-field hiddendiv" id="div7">
                                <input placeholder="Réponse n°7" id="answer7" type="text" name="answer">
                                <label for="answer7">Réponse n°7</label>
                            </div>
                            <div class="input-field hiddendiv" id="div8">
                                <input placeholder="Réponse n°8" id="answer8" type="text" name="answer">
                                <label for="answer8">Réponse n°8</label>
                            </div>
                            <div class="input-field hiddendiv" id="div9">
                                <input placeholder="Réponse n°9" id="answer9" type="text" name="answer">
                                <label for="answer9">Réponse n°9</label>
                            </div>
                            <div class="center-align">

                            </div>
                            <div class="center-align">
                                <button class="btn blue waves-effect waves-light" type="submit">Créer</button>
                                <button class="btn red waves-effect waves-light" type="reset">Annuler</button>
                            </div>
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
<script type="text/javascript">
    var i = 1;
    function addAnswer() {
        if(i < 10){
            i++;
            var div = $("#div"+i);
            div.removeClass("hiddendiv");
            div.hide().fadeIn(2000);
            $("#removeButton").removeClass("disabled");
        }
    }
    function removeAnswer() {
        if(i > 1){
            var div = $("#div"+i);
            $("#div"+ i +" > :input").val("");
            div.show().fadeOut(2000);
            //div.fadeOut(3000);
            //div.addClass("hiddendiv");
            i--;
        } else {
            $("#removeButton").addClass("disabled");
        }
    }
</script>
</body>
</html>
