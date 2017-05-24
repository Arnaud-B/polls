<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul id="slide-out" class="collapsible side-nav fixed collection" data-collapsible="accordion">
    <li class="bold logo">
        <a href="" class="collapsible-header waves-effect waves-blue brand-logo">Polls Project</a>
    </li>
    <li class="bold">
        <a class="collapsible-header waves-effect waves-blue" href="/stats"><i class="small material-icons">assessment</i>Statistiques</a>
    </li>
    <li class="bold">
        <a class="collapsible-header waves-effect waves-blue" href="#!"><i class="small material-icons">assignment_ind</i>Gestion des rédacteurs</a>
        <div class="collapsible-body">
            <ul>
                <li>
                    <a class="waves-effect waves-blue" href="/list/users"><i class="small material-icons" style="margin-left: -3px">view_headline</i>Voir la liste des rédacteurs</a>
                </li>
                <li>
                    <a class="waves-effect waves-blue" href="/create/user"><i class="small material-icons">playlist_add</i>Créer un rédacteur</a>
                </li>
            </ul>
        </div>
    </li>
    <li class="bold">
        <a  class="collapsible-header waves-effect waves-blue" href="#!"><i class="small material-icons">assignment</i>Gestion des sondages</a>
        <div class="collapsible-body">
            <ul>
                <li>
                    <a class="waves-effect waves-blue" href="/list/polls"><i class="small material-icons" style="margin-left: -3px">view_headline</i>Voir la liste des sondages</a>
                </li>
                <li>
                    <a class="waves-effect waves-blue" href="/create/poll"><i class="small material-icons">playlist_add</i>Créer un sondage</a>
                </li>
            </ul>
        </div>
    </li>
</ul>
<a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>