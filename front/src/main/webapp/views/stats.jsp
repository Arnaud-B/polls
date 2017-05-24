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
                        <li class="collection-item"><div>Sondage n°1<a href="/get/poll/1" class="secondary-content"><i class="material-icons">send</i></a></div></li>
                        <li class="collection-item"><div>Sondage n°2<a href="/get/poll/2" class="secondary-content"><i class="material-icons">send</i></a></div></li>
                        <li class="collection-item"><div>Sondage n°3<a href="/get/poll/3" class="secondary-content"><i class="material-icons">send</i></a></div></li>
                        <li class="collection-item"><div>Sondage n°4<a href="/get/poll/4" class="secondary-content"><i class="material-icons">send</i></a></div></li>
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
                    <div class="input-field col s12">
                        <select>
                            <option value="" disabled selected>Sélectionnez un sondage</option>
                            <option class="blue-text" value="1">Sondage n°1</option>
                            <option class="blue-text" value="2">Sondage n°2</option>
                            <option class="blue-text" value="3">Sondage n°3</option>
                        </select>
                        <label>Sondage</label>
                    </div>
                    <h4 class="blue-text">Histogramme du nombre de réponses par tranche d'âge</h4>
                    <canvas id="myChart" width="400" height="400"></canvas>
                    <h4 class="blue-text">Histogramme des réponses par tranche d'âge</h4>
                </div>
            </div>
        </div>
    </div>
</main>
<%--<jsp:include page="footer.jsp"/>--%>
<jsp:include page="import_js.jsp"/>
<script src="<c:url value="/resources/js/theme.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/Chart.bundle.min.js"/> " type="text/javascript"></script>
<script>
    var ctx = document.getElementById("myChart");
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ["-10", "10-15", "15-20", "20-25", "25-30", "30-35", "35-40", "40-45", "45-50", "50-55", "55-60", "60-65", "65-70", "70-75", "75-80", "80-85", "85-90"],
            datasets: [{
                label: "Nombres de réponses par tranche d'âge",
                data: [12, 19, 3, 5, 2, 3],
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor: 'rgba(255,99,132,1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero:true
                    },
                    scaleLabel : {
                        display : true,
                        labelString : "Nombre de réponses"
                    }
                }],
                xAxes: [{
                    scaleLabel : {
                        display : true,
                        labelString : "Âge"
                    }
                }]
            }
        }
    });
</script>
</body>
</html>
