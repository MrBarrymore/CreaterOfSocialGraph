<#import "parts/common.ftl" as c>
<#import "parts/requestForm.ftl" as r>
<@c.page>

    <@r.request "/request" />

    <div> <h3>Список объектов социального графа</h3> </div>

    <div id="listDiv">
<#--        <#list listOfSocialObjects as socialObject>-->
<#--            <div>-->
<#--                <b>${socialObject.id}</b>-->
<#--               <span>${socialObject.lastname}</span>-->
<#--                <span> ${socialObject.name}</span>-->
<#--                </span>${socialObject.socialObjectGroup}</span>-->
<#--            </div>-->
<#--             <#else>-->
<#--             No socialObject-->
<#--         </#list>-->
    </div>

    <div id="graph">
        <script type="text/javascript" src="https://gc.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js" charset="UTF-8"></script>
        <style>
            .node {
                stroke: #fff;
                stroke-width: 1.5px;
            }

            .link {
                fill: none;
                stroke: #bbb;
            }
        </style>

        <#--<script src="//d3js.org/d3.v3.min.js"></script>-->
        <#--<script src="https://d3js.org/d3.v4.min.js"></script>-->
        <svg width="960" height="600"></svg>
        <script src="https://d3js.org/d3.v4.min.js"></script>
        <script src="/js/GraphBuilder.js"></script>

    </div>
</@c.page>