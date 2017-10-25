<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<title>Sign in</title>

<a href="/sign_up">Sign up</a>

<#if error??>
Bad creds
</#if>

<@sf.form role="form" action='/login/process' method="post" modelAttribute="authForm">
<fieldset>
    <div class="field" style="width: 20%">
        <@sf.label path="email">Email</@sf.label>
        <@sf.input path="email" cssClass="form-control" type="email"/>
        <@sf.errors path="email" cssClass="help-block"/>
    </div>
    <div class="field" style="width: 20%">
        <@sf.label path="password">Password</@sf.label>
        <@sf.input path="password" cssClass="form-control" type="password"/>
        <@sf.errors path="password" cssClass="help-block"/>
    </div>
    <div class="form-group">
        <input class="btn btn-info btn-outline" type="submit" value="Sing in">
    </div>
</fieldset>

</@sf.form>

