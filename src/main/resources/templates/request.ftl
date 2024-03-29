<#import "parts/common.ftl" as c>
<#import "parts/requestForm.ftl" as r>

<@c.page>

    <#--<@r.request "/request" />-->

    <main class="main ml-4 mr-4"">

    <div class="row justify-content-md-center">

        <div id="requestForm" class="col-2">

            <form>
                <div class="form-group">
                    <label for="inputState">Наименование атрибута</label>
                    <select name="attributeName" id="attributeNameInput" class="form-control">
                        <option selected>Выберете атрибут...</option>
                        <option>city</option>
                        <option>university</option>
                        <option>school</option>
                    </select>
                </div>
                <div>
                    <label for="inputName">Название атрибута</label>
                    <input type="text" name="name" id="nameInput" class="form-control"  placeholder="Например: Барнаул" />
                    <div class="valid-feedback">
                        Looks good!
                    </div>
                </div>

                <div>
                    <label for="inputName">Количество людей в изначальной выборке</label>
                    <input type="text" name="objectsCount" id="objectsCount" class="form-control"  placeholder="Например: 20" />
                </div>

                <div class="form-group">
                    <label for="inputState">Желаемый рейтинг >= чем</label>
                    <select name="ratingCount" id="ratingCount" class="form-control">
                        <option selected>100</option>
                        <option>75</option>
                        <option>50</option>
                        <option>25</option>
                        <option>0</option>
                    </select>
                </div>

                <div>
                    <label id="information"><b></b></label>
                </div>

                <input type="hidden" name="_csrf" value="" />
                <button type="button" onclick="buildGraph()" class="btn btn-primary">Новый поиск</button>
                <button type="button" onclick="updateGraph()" class="btn btn-primary">Обновить</button>
            </form>

        </div> <#-- /.col-3-->

        <div class="col-9"">

        <div id="graph" class="container d-flex flex-column justify-content-center align-items-center">
            <h5 class="display-5">Визуализация социального графа</h5>

            <div id="graphDiv" class="container">
                <svg width="960" height="600"></svg>
                <script src="//d3js.org/d3.v3.min.js"></script>

                <script src="/js/graphAndListBuilder.js"></script>
                <script src="/js/updateGraph.js"></script>
            </div>
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
                    <th scope="col">Количество друзей</th>
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