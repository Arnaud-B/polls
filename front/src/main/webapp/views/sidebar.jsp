<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul id="slide-out" class="collapsible side-nav fixed collection" data-collapsible="accordion">
    <li class="bold logo">
        <a href="" class="collapsible-header waves-effect waves-blue brand-logo">Polls Project</a>
    </li>
    <security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_READER')">
        <li class="bold">
            <a class="collapsible-header waves-effect waves-blue" href="/stats/"><i class="small material-icons">assessment</i>Statistiques</a>
        </li>
    </security:authorize>
    <security:authorize access="hasRole('ROLE_ADMIN')">
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
    </security:authorize>
    <li class="bold">
        <a  class="collapsible-header waves-effect waves-blue" href="#!"><i class="small material-icons">assignment</i>Gestion des sondages</a>
        <div class="collapsible-body">
            <ul>
                <li>
                    <a class="waves-effect waves-blue" href="/session/list/"><i class="small material-icons" style="margin-left: -3px">view_headline</i>Voir la liste des sondages</a>
                </li>
                <security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_READER')">
                    <li>
                        <a class="waves-effect waves-blue" href="/session/create/"><i class="small material-icons">playlist_add</i>Créer un sondage</a>
                    </li>
                </security:authorize>
            </ul>
        </div>
    </li>
    <li class="bold">
        <a class="collapsible-header waves-effect waves-blue" href="/logout"><i class="small material-icons">power_settings_new</i>Se déconnecter</a>
    </li>
</ul>
<a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>