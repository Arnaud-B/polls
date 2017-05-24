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
    <title>Statistiques du sondage n°${id}</title>
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
                    <h3 class="blue-text">Histogrammes</h3>
                    <h4>
                        Histogramme du nombre de réponses par tranche d'âge.
                    </h4>
                    <canvas id="myChart"></canvas>
                    <h4>
                        Histogrammes des réponses par tranche d'âge
                    </h4>
                    <div class="row">
                        <div class="col s4">
                            <h5 class="center-align">Réponse n°1</h5>
                            <canvas id="answer1"></canvas>
                        </div>
                        <div class="col s4">
                            <h5 class="center-align">Réponse n°2</h5>
                            <canvas id="answer2"></canvas>
                        </div>
                        <div class="col s4">
                            <h5 class="center-align">Réponse n°3</h5>
                            <canvas id="answer3"></canvas>
                        </div>
                        <div class="divider col s12" style="margin-top: 20px; margin-bottom: 20px;"></div>
                        <div class="col s4">
                            <h5 class="center-align">Réponse n°4</h5>
                            <canvas id="answer4"></canvas>
                        </div>
                        <div class="col s4">
                            <h5 class="center-align">Réponse n°5</h5>
                            <canvas id="answer5"></canvas>
                        </div>
                        <div class="col s4">
                            <h5 class="center-align">Réponse n°6</h5>
                            <canvas id="answer6"></canvas>
                        </div>
                    </div>
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
    var answer1 = document.getElementById("answer1");
    var answer2 = document.getElementById("answer2");
    var answer3 = document.getElementById("answer3");
    var answer4 = document.getElementById("answer4");
    var answer5 = document.getElementById("answer5");
    var answer6 = document.getElementById("answer6");

    var labels = ["-10", "10-15", "15-20", "20-25", "25-30", "30-35", "35-40", "40-45", "45-50", "50-55", "55-60", "60-65", "65-70", "70-75", "75-80", "80-85", "85-90"];
    var backgroundColor = "#78909c";
    var backgroundColorPie = [
        "#eceff1",
        "#cfd8dc",
        "#b0bec5",
        "#90a4ae",
        "#78909c",
        "#607d8b",
        "#546e7a",
        "#455a64",
        "#37474f",
        "#263238",
        "#757575",
        "#616161",
        "#424242",
        "#212121"
    ];
    var borderColor = 'white';
    var dataPie = [12, 19, 3, 5, 2, 3];
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: "Nombres de réponses par tranche d'âge",
                data: dataPie,
                backgroundColor: backgroundColor,
                borderColor: borderColor,
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

    var answer1Pie = new Chart(answer1, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                label: "Nombres de réponse par tranche d'âge pour la réponse n°1",
                data: dataPie,
                backgroundColor: backgroundColorPie,
                borderColor: borderColor,
                borderWidth: 1
            }]
        }
    });
    var answer2Pie = new Chart(answer2, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                label: "Nombres de réponse par tranche d'âge pour la réponse n°2",
                data: dataPie,
                backgroundColor: backgroundColorPie,
                borderColor: borderColor,
                borderWidth: 1
            }]
        }
    });
    var answer3Pie = new Chart(answer3, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                label: "Nombres de réponse par tranche d'âge pour la réponse n°3",
                data: dataPie,
                backgroundColor: backgroundColorPie,
                borderColor: borderColor,
                borderWidth: 1
            }]
        }
    });
    var answer4Pie = new Chart(answer4, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                label: "Nombres de réponse par tranche d'âge pour la réponse n°4",
                data: dataPie,
                backgroundColor: backgroundColorPie,
                borderColor: borderColor,
                borderWidth: 1
            }]
        }
    });
    var answer5Pie = new Chart(answer5, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                label: "Nombres de réponse par tranche d'âge pour la réponse n°5",
                data: dataPie,
                backgroundColor: backgroundColorPie,
                borderColor: borderColor,
                borderWidth: 1
            }]
        }
    });
    var answer6Pie = new Chart(answer6, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                label: "Nombres de réponse par tranche d'âge pour la réponse n°6",
                data: dataPie,
                backgroundColor: backgroundColorPie,
                borderColor: borderColor,
                borderWidth: 1
            }]
        }
    });
</script>
</body>
</html>
