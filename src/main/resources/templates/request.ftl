<#import "parts/common.ftl" as c>
<#import "parts/requestForm.ftl" as r>
<@c.page>

    <@r.request "/request" />

    <div> <h3>Список объектов социального графа</h3> </div>

    <div>
        <#list listOfSocialObjects as socialObject>
            <div>
                <b>${socialObject.id}</b>
               <span>${socialObject.lastname}</span>
                <span> ${socialObject.name}</span>
                </span>${socialObject.socialObjectGroup}</span>
            </div>
             <#else>
             No socialObject
         </#list>
    </div>

    <div>

        <style>
            .link {
                stroke: #ccc;
            }
            .node text {
                pointer-events: none;
                font: 10px sans-serif;
            }
        </style>

        <script src="//d3js.org/d3.v3.min.js"></script>
        <script src="/js/GraphBuilder.js"></script>

    </div>
</@c.page>