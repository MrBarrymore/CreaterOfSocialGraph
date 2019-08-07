<#import "parts/common.ftl" as c>
<#import "parts/requestForm.ftl" as r>

<@c.page>

    <div class="col-12" id="messageContainer">
        <h6 lass="display-6">
            <p>Данный сервис предназначен для запроса информации о пользователях социальной сети ВК и построения
                социального графа, на основе полученной информации.
            </p>
            <p> На странице представлена форма для построения графа из заранее взятой с сервера выборки.
                За атрибут было взято название университета, в качестве названия: "АлтГТУ им. Ползунова".
                Исходная выборка содержит 1483 социальных объекта.
                В процессе обработки каждый из социальных объектов преобритает рейтинг соответствия выбранному критерию.
                Например, если у пользователя социальной сети указан ВУЗ: "АлтГТУ им. Ползунова", то его рейтинг равен 100.
                Рейтинг всех остальных социальных объектов расчитывается исходя из количества друзей, рейтинг которых составляет
                100 % и общего количества друзей.
            </p>
        </h6>
    </div>

    <main class="main ml-4 mr-4"">

    <div class="row justify-content-md-center">

        <div id="requestForm" class="col-2">

            <form>
                <div>
                    <label for="inputName">Название атрибута</label>
                    <input type="text" name="name" id="nameInput" class="form-control"  value="АлтГТУ им. Ползунова" />
                    <div class="valid-feedback">
                        Looks good!
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputState">Наименование атрибута</label>
                    <select name="attributeName" id="attributeNameInput" class="form-control">
                        <option>Выберете атрибут...</option>
                        <option>city</option>
                        <option selected>university</option>
                        <option>school</option>
                    </select>
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
                <button type="button" onclick="createExampleGraph()" class="btn btn-primary">Построить</button>
            </form>

        </div> <#-- /.col-3-->

        <div class="col-9"">

        <div id="graph" class="container d-flex flex-column justify-content-center align-items-center">
            <#--<script type="text/javascript" src="https://gc.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js" charset="UTF-8"></script>-->
            <h5 class="display-5">Визуализация социального графа</h5>

            <div id="graphDiv" class="container">
                <svg width="960" height="600"></svg>
                <script src="//d3js.org/d3.v3.min.js"></script>
                <script src="/js/createExampleGraph.js"></script>
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
                    <th scope="col">Количество связей</th>
                    <th scope="col">Рейтинг (%)</th>
                </tr>
                </thead>
                <tbody id ="listDiv"></tbody>
            </table>

        </div>

    </div> <#-- /.col-6-->

    </div>  <#-- /.row-->
    </main>


</@c.page>