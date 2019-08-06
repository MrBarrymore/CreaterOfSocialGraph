<#import "parts/common.ftl" as c>
<#import "parts/requestForm.ftl" as r>

<@c.page>

    <#--<@r.request "/request" />-->

    <main class="main ml-4 mr-4"">

        <div class="row justify-content-md-center">

            <div id="requestForm" class="col-2">
                <form action="javascript:testtest()">
                    <div>
                        <label for="inputAddress">Название атрибута</label>
                        <input type="text" name="name" id="nameInput" class="form-control" placeholder="Барнаул" />
                    </div>
                    <div class="form-group">
                        <label for="inputState">Наименование атрибута</label>
                        <select name="attributeName" id="attributeNameInput" class="form-control">
                            <option selected>Выберете атрибут...</option>
                            <option>city</option>
                            <option>university</option>
                            <option>school</option>
                        </select>
                    </div>
                    <input type="hidden" name="_csrf" value="" />
                    <button type="submit" class="btn btn-primary">Поиск</button>
                </form>
            </div> <#-- /.col-3-->

            <div class="col-9"">

            <div id="graph" class="container d-flex flex-column justify-content-center align-items-center">
                    <script type="text/javascript" src="https://gc.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js" charset="UTF-8"></script>
                    <h5 class="display-5">Визуализация социального графа</h5>

                    <div id="graphDiv" class="container">
                        <svg width="960" height="600"></svg>
                        <script src="//d3js.org/d3.v3.min.js"></script>
                        <#--<script src="https://d3js.org/d3.v4.min.js"></script>-->
                        <script src="/js/resultBuilder1.js"></script>
                    </div>

                    <#--<script src="//d3js.org/d3.v3.min.js"></script>-->
                    <#--<script src="https://d3js.org/d3.v4.min.js"></script>-->

                </div>

                <div id="objectsList" class="container d-flex flex-column justify-content-start align-items-center">
                    <h5 class="display-5">Список объектов социального графа</h5>
                        <table class="table" overflow="auto">
                            <thead>
                            <tr>
                                <th scope="col">id</th>
                                <th scope="col">Фамилия Имя</th>
                                <th scope="col">Город</th>
                                <th scope="col">Ссылка в ВК</th>
                                <th scope="col">Количество связей</th>
                                <th scope="col">Рейтинг (%)</th>
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