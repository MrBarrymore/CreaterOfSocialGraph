<#import "parts/common.ftl" as c>
<#import "parts/requestForm.ftl" as r>

<@c.page>

    <#--<@r.request "/request" />-->

    <style>

        .node {
            stroke: #fff;
            stroke-width: 1.5px;
        }

        .link {
            fill: none;
            stroke: #bbb;
        }

        .body {
            background: whitesmoke;
        }

        .main {
            background: whitesmoke;
            /*margin-left: 60px;*/
            position: center;
        }

        .container, #maindiv {
            background: white;
            /*position: center;*/
            margin-left: 60px;
        }

        .col-3 {
            background: white;
        }

        #requestForm, #objectsList {
            margin-bottom: 10px ;
            margin-top: 10px ;
            background: white;
        }


    </style>

    <main class="main ml-4 mr-4"">

        <div class="row">

            <div id="requestForm" class="col-3">
                <form action="javascript:testtest()">
                    <div>
                        <label for="inputAddress">Название атрибута</label>
                        <input type="text" name="name" id="nameInput" class="form-control" placeholder="Барнаул" />
                    </div>
                    <div class="form-group">
                        <label for="inputState">Наименование атрибута</label>
                        <select name="attributeName" id="attributeNameInput" class="form-control">
                            <option selected>Выберете атрибут...</option>
                            <option>Город</option>
                            <option>Университет</option>
                            <option>Школа</option>
                        </select>
                    </div>
                    <input type="hidden" name="_csrf" value="" />
                    <button type="submit" class="btn btn-primary">Поиск</button>
                </form>
            </div> <#-- /.col-3-->

            <div class="col-6"">
                <div id="graph" class="container d-flex flex-column justify-content-center align-items-center">
                    <script type="text/javascript" src="https://gc.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js" charset="UTF-8"></script>
                       <h5 class="display-5">Визуализация социального графа</h5>

                    <div>
                        <svg width="960" height="500"></svg>
                        <script src="https://d3js.org/d3.v4.min.js"></script>
                        <script src="/js/resultBuilder.js"></script>
                    </div>

                    <#--<script src="//d3js.org/d3.v3.min.js"></script>-->
                    <#--<script src="https://d3js.org/d3.v4.min.js"></script>-->

                </div>

                <div id="objectsList" class="container d-flex flex-column justify-content-center align-items-center">
                    <h5 class="display-5">Список объектов социального графа</h5>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Фамилия</th>
                        <th scope="col">Имя</th>
                        <th scope="col">Группа</th>
                    </tr>
                    </thead>
                    <tbody id ="listDiv">
                    </tbody>
                </table>
                </div>

            </div> <#-- /.col-6-->

        </div>  <#-- /.row-->
    </main>

</@c.page>