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
                                <input placeholder="Nom" id="name" name="name" type="text" class="validate">
                                <label for="name">Nom</label>
                            </div>
                            <div class="input-field">
                                <input placeholder="Date de début" type="date" class="datepicker" id="start-date" name="start_date">
                                <label for="start-date">Date de début</label>
                            </div>
                            <div class="input-field">
                                <input placeholder="Date de fin" type="date" class="datepicker" id="end-date" name="end_date">
                                <label for="start-date">Date de fin</label>
                            </div>
                            <div class="input-field">
                                <input placeholder="Question" id="question" name="question" type="text" class="validate">
                                <label for="question">Question</label>
                            </div>
                            <div id="answers">
                                <div class="input-field">
                                    <input placeholder="Réponse n°1" id="answer1" type="text" name="answer">
                                    <label for="answer1">Réponse n°1</label>
                                </div>
                            </div>
                            <div class="center-align">

                            </div>
                            <div class="center-align">
                                <button <c:if test="${disabled_button}">disabled</c:if> class="btn blue waves-effect waves-light" type="submit">Créer</button>
                                <button <c:if test="${disabled_button}">disabled</c:if> class="btn red waves-effect waves-light" type="reset">Annuler</button>
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
            var html = "<div class='input-field' id='input_"+ i +"'>" +
                "<input placeholder='Réponse n°" + i + "' id='answer" + i + "' type='text' name='answer' class='validate'>" +
                "<label for='answer" + i + "'>Réponse n°" + i + " </label>" +
                "</div>";
            $(html).hide().appendTo("#answers").fadeIn(1000);
            if(i > 1)
                $("#removeButton").removeClass("disabled");
        }
    }
    function removeAnswer() {
        if(i > 1){
            var div = $("#input_"+i);
            $("#input_"+ i +" > :input").val("");
            div.remove();
            i--;
            if(i == 1)
                $("#removeButton").addClass("disabled");
        }
    }
    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 15, // Creates a dropdown of 15 years to control year
        labelMonthNext: 'Mois prochain',
        labelMonthPrev: 'Mois dernier',
        labelMonthSelect: 'Sélection du mois',
        labelYearSelect: 'Sélection de l\'année',
        monthsFull: ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'],
        monthsShort: ['Jan', 'Fév', 'Mar', 'Avr', 'Mai', 'Juin', 'Juil', 'Août', 'Sept', 'Oct', 'Nov', 'Déc'],
        weekdaysFull: ['Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'],
        weekdaysShort: ['Dim', 'Lun', 'Mar', 'Mer', 'Jeu', 'Ven', 'Sam' ],
        weekdaysLetter: ['D', 'L', 'Mar', 'Mer', 'J', 'V', 'S' ],
        today: 'Aujourd\'hui',
        clear: 'Effacer',
        close: 'Fermer',
        format: 'dd/mm/yyyy'
    });
</script>
</body>
</html>
