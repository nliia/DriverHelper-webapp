<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li class="active"><a href="/home">Активные</a></li>
            <li class="active"><a href="/archived">Архив</a></li>
        </ul>
    </div>
</nav>

<#if dtpList??>
    <#list dtpList as dtp>
    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="panel-title" id="center-content-area">
                    <#if dtp.dateD??>Время: ${dtp.dateD?date} ${dtp.dateD?time}</h4>
                    <#else>
                        Дата: 28.10.2017
                    </#if>
                    <#if dtp.fullDtpPlace??>Адрес: ${dtp.fullDtpPlace}</h4>
                    <#else>
                        Адрес: Казань
                    </#if>
                    <form action="/upload/${dtp.id}" METHOD="get" style="width: 10px">
                        <p><input type="submit" name="Скачать" value="Скачать протокол" class="btn"></p>
                    </form>

                    <form action="/upload/${dtp.id}" METHOD="get" style="width: 10px">
                        <p><input type="submit" name="Скачать" value="В архив" class="btn"></p>
                    </form>
                    <br>
                </div>
            </div>
        </div>
    </div>
    </#list>
</#if>