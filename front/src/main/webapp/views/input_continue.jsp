<%--
  Created by IntelliJ IDEA.
  User: Corentin
  Date: 20/06/2017
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="input-field" id="input_password">
    <input placeholder="Mot de passe" id="password" name="password" type="password" class="validate" value="default" hidden>
    <label for="password">Mot de passe</label>
</div>
<button class="btn blue waves-effect waves-light" id="submit" type="submit" name="action">Se connecter en tant que <%=request.getAttribute("username")%></button>

