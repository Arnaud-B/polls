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
                        <c:forEach var="response" items="${responses}" varStatus="loopCounter">
                        <div class="col s4">
                            <h5 class="center-align">Réponse n°${loopCounter.count}</h5>
                            <canvas id="answer${loopCounter.count}"></canvas>
                        </div>
                        </c:forEach>
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
    var age_group = ${age_group};
    var age_group_per_response = ${age_group_per_response};

    var responses = ${responses_json};
    var ctx = document.getElementById("myChart");
    var answers = new Array();
    for(i=0; i<responses.length; i++) {
        answers[i] = document.getElementById("answer"+(i+1));
    }


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
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: "Nombres de réponses par tranche d'âge",
                data: age_group,
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

    var prefix = "answer"
    var end = "Pie";
    for(j=0; j<answers.length; j++) {
        var index = j+1;
        this[prefix+index+end] = new Chart(answers[j], {
            type: 'pie',
            data: {
                labels: labels,
                datasets: [{
                    label: "Nombres de réponse par tranche d'âge pour la réponse n°"+index,
                    data: age_group_per_response[j],
                    backgroundColor: backgroundColorPie,
                    borderColor: borderColor,
                    borderWidth: 1
                }]
            }
        });
    }
</script>
</body>
</html>
