<#import "parts/common.ftl" as c>
<#import "parts/requestForm.ftl" as r>

<@c.page>

    <@r.request "/request" />

<#--    <div>
        <h3>Список объектов социального графа</h3>
        &lt;#&ndash;<div id="app">{message}</div>&ndash;&gt;
        &lt;#&ndash;<script src="js/main.js"></script>&ndash;&gt;
    </div>-->


<#-- <#list listOfSocialObjects as socialObject>
    <div>
        <h3>Список объектов социального графа</h3>
        <b>${socialObject.id}</b>
       <span>${socialObject.lastname}</span>
        <span> ${socialObject.name}</span>
        &lt;#&ndash;<i>${socialObject.socialObjectGroup}</i>&ndash;&gt;

        &lt;#&ndash;<script src="../static/js/main.js"></script>&ndash;&gt;
    </div>
     <#else>
     No socialObject
 </#list>-->

</@c.page>