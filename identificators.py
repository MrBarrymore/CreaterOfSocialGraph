import vk
import json

# получение идентификаторов по запросу 
session = vk.Session(access_token='6a99b6dce7c59daac6a76e3703ab3b75b6ddc9f4ee569c9ef1173c07cee4638d2c47e9eab2c22753863af')
api = vk.API(session, v='5.101', lang='ru', timeout=10)
zapros = '' # тип запроса 
attribute_str = '' # запрос от пользователя
city_id = 1
attribute = {
    'Город': api.database.getCities(country_id = 1, q = attribute_str),
    'Школа': api.database.getSchools(city_id = city_id, q =attribute_str),
    'Университет':  api.database.getUniversities(q = attribute_str),
}
ident_json = attribute[zapros] # json со всеми совпадениями и их идентификаторами
