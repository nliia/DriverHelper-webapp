<#if var??>
${var}!!!
</#if>
<script>
    var eventSource = new EventSource("https://dtp-hack.herokuapp.com/sseTest");
    eventSource.onopen = function (e) {
        console.log("Соединение открыто");
    };

    eventSource.onmessage = function (e) {
        console.log("Пришло сообщение: " + e.data);
    };
</script>