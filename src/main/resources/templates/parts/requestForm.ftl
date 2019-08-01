<#macro request path>

    <div>
        <form method="post" action="/request">
            <div>  <input type="text" name="text" placeholder="Название атрибута" /> </div>
            <div> <input type="text" name="tag" placeholder="Наименование атрибута"> </div>
            <input type="hidden" name="_csrf" value="" />
            <button type="submit">Поиск</button>
        </form>
    </div>

</#macro>