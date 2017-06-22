<%--
  Created by IntelliJ IDEA.
  User: Corentin
  Date: 19/06/2017
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="input-field" id="input_age">
    <input placeholder="Age" id="age" name="age" type="text" pattern="[0-9]*" class="validate">
    <label for="age">Age</label>
</div>
<div class="input-field" id="input_password">
    <input placeholder="Mot de passe" id="password" name="password" type="password" class="validate" value="default" hidden>
    <label for="password">Mot de passe</label>
</div>
<button class="btn blue waves-effect waves-light" id="submit" type="submit" name="action" onclick="return changeAge()">Se connecter</button>
<script>
    function changeAge() {
        var input = $("#username").val();
        var age = $("#age").val();
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
        };
        xhttp.open("GET", "/login/change?username=" + input +"&age=" + age, false);
        xhttp.send();
        return true;
    }
</script>

