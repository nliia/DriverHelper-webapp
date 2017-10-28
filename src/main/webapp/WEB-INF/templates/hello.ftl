<link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>

<script>
    var eventSource = new EventSource("https://dtp-hack.herokuapp.com/sseTest");
    eventSource.onopen = function (e) {
        console.log("Соединение открыто");
    };

    eventSource.onmessage = function (e) {
        console.log("Пришло сообщение: " + e.data);
    };
</script>

<div class="panel-group" id="accordion">
<div class="panel panel-default">
<div class="panel-heading">
<div class="panel-title">
<#if dtpList??>
    <#list dtpList as dtp>
        Дата: 28.10.2017
        Адрес: ${dtp.fullDtpPlace}
        <form action="/upload/${dtp.id}" METHOD="get" style="width: 10px">
            <p><input type="submit" name="Скачать" value="Скачать протокол" class="btn"></p>
        </form>
        <br>
    </div>
    </div>
    </div>
    </div>
    </#list>
</#if>

