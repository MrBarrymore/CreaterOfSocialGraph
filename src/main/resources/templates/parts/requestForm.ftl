<#macro request path>

    <div>
        <form method="post" action="/request">
            <div>
                <label for="inputAddress">Название атрибута</label>
                <input type="text" name="text" class="form-control" placeholder="Барнаул" />
            </div>
            <div class="form-group">
                <label for="inputState">Наименование атрибута</label>
                <select name="tag" id="inputState" class="form-control">
                    <option selected>Выберете атрибут...</option>
                    <option>Город</option>
                    <option>Университет</option>
                    <option>Школа</option>
                </select>
            </div>
            <input type="hidden" name="_csrf" value="" />
            <button type="submit" class="btn btn-primary">Поиск</button>
        </form>
    </div>
</#macro>