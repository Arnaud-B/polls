<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul id="slide-out" class="collapsible side-nav fixed collection" data-collapsible="accordion">
<c:choose>
    <c:when test="${current_user == null}">
        <li class="bold">
            <a href="/login/" class="btn red waves-effect waves-light">Se connecter</a>
            <a href="" class="collapsible-header waves-effect waves-blue">Non connecté</a>
        </li>
        <li class="bold logo">
            <a href="" class="collapsible-header waves-effect waves-blue brand-logo">Polls Project</a>
        </li>
    </c:when>
    <c:otherwise>
        <li class="bold">
            <a href="/logout/" class="btn red waves-effect waves-light">Se déconnecter</a>
            <a href="" class="collapsible-header waves-effect waves-blue">connecté en tant que ${current_user.getUsername()}</a>
        </li>
        <li class="bold logo">
            <a href="" class="collapsible-header waves-effect waves-blue brand-logo">Polls Project</a>
        </li>
        <c:if test="${current_user.getRole()!=role_user}">
            <li class="bold">
                <a class="collapsible-header waves-effect waves-blue" href="/stats/"><i class="small material-icons">assessment</i>Statistiques</a>
            </li>
            <li class="bold">
                <a class="collapsible-header waves-effect waves-blue" href="#!"><i class="small material-icons">assignment_ind</i>Gestion des rédacteurs</a>
                <div class="collapsible-body">
                    <ul>
                        <li>
                            <a class="waves-effect waves-blue" href="/user/list/"><i class="small material-icons" style="margin-left: -3px">view_headline</i>Voir la liste des rédacteurs</a>
                        </li>
                        <li>
                            <a class="waves-effect waves-blue" href="/user/create/"><i class="small material-icons">playlist_add</i>Créer un rédacteur</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="bold">
                <a  class="collapsible-header waves-effect waves-blue" href="#!"><i class="small material-icons">assignment</i>Gestion des sondages</a>
                <div class="collapsible-body">
                    <ul>
                        <li>
                            <a class="waves-effect waves-blue" href="/session/list/"><i class="small material-icons" style="margin-left: -3px">view_headline</i>Voir la liste des sondages</a>
                        </li>
                        <li>
                            <a class="waves-effect waves-blue" href="/session/create/"><i class="small material-icons">playlist_add</i>Créer un sondage</a>
                        </li>
                    </ul>
                </div>
            </li>
        </c:if>
        <c:if test="${current_user.getRole()==role_user}">
            <li class="bold">
                <a class="waves-effect waves-blue" href="/session/list/">
                    <i class="small material-icons" style="margin-left: -3px">view_headline</i>Voir la liste des sondages
                </a>
            </li>
        </c:if>
    </c:otherwise>
</c:choose>
</ul>
<a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>