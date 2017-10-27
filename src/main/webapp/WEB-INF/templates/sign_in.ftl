<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>

<title>Sign in</title>

<center style="margin-top: 15%;">
<div style="width: 20%;border: solid 3px grey; border-radius: 10px; padding: 15px;">
<#if error??>
    Bad creds
</#if>

<@sf.form role="form" action='/login/process' method="post" modelAttribute="authForm">
    <fieldset>
        <div class="field">
            <@sf.label path="email">Email</@sf.label>
            <@sf.input path="email" cssClass="form-control" type="email"/>
            <@sf.errors path="email" cssClass="help-block"/>
        </div>
        <div class="field" style="padding-top: 5%">
            <@sf.label path="password">Password</@sf.label>
            <@sf.input path="password" cssClass="form-control" type="password"/>
            <@sf.errors path="password" cssClass="help-block"/>
        </div>
        <div class="form-group" style="padding-top: 5%">
            <input class="btn btn-info btn-outline" type="submit" value="Sing in">
        </div>
    </fieldset>



</@sf.form>
</div>
</center>
