# TouristBot for Resliv

###Имя бота: Tourist_Bot_for_test_bot
###Токен: 1869751325:AAFLjbqxNwSgWh1WyoqNw-v2G7bZ8JgwYU0

Имя, токен, логин и пароль для базы данных (mySQL) уже находятся в файле application.properties
Ничего дополнительно вводить не нужно.

Для запуска приложения запустить класс TouristApplication. 
При его инициализации телеграм-бот и web-сервисы начнут свою работу.

Web-интерфейс расположен по адресу:
### http://localhost:8090/table

Страница представляет собой таблицу со всеми городами, присутствующими в базе данных на данный момент.
Есть функции добавить, удалить, редактировать данные в таблице с помошью соответсвующих гиперссылок и кнопок.

Пример информации для заполнения таблицы:

 - Бангкок - Bangkok - Ни теряя ни минуты бегите в Храм "Изумрудного Будды	Удалить	Изменить
 - Дубаи - Dubai - Надеемся вы не боитесь высоты, потому что у нас для вас обзорная площадка на 148 этаже башни Бурдж-Халифа	Удалить	Изменить
 - Минск - Minsk - Минск - город герой! Поэтому рекомендуем Музей ВОВ.	Удалить	Изменить
 - Москва - Moscow - Красная Площадь по прежнему в фаворитах!	Удалить	Изменить
 - Нью-Йорк - New-York - В хорошую погоду прогуляйтесть в Центральном парке, в плохую - отправляйтесь в Метрополитен-музей	Удалить	Изменить
 - Париж - Paris - Днем вас ждут Елисейские поля, а вечером - смотровая платформа Эйфилевой башни	Удалить	Изменить
 - Сеул - Seoul - Здесь оочень много дворцов! Но мы предлагаем начать с Дворца Чхангёнгун

Для начала работы с ботом нажмите кнопку Start или отправьте сообщение "/start". После этого появится приветственное сообщение. Бот обрабатывает запросы как на расском так и на английском языке. Например, при вводе "Moscow" и "Москва" результат вывода будет одинаковым.
Также в боте предусмотренны две reply кнопки. 
Кнопка "Помошь" напоминает правила пользования ботом и его функционал.
Кнопка "Список гордов" выдает массив городов (на русском языке) имеющихся в данный момент вбазе данных.
При отсутсвии города в списке выдается сообщение "К сожалению данный город отсутсвует в нашей базе".
При отстуствии городов в списке (пустая база данных) выдается сообщение "Наша база пока пуста. Скоро мы это исправим".

Таким образом телеграм бот web-сервис полностью выполняют поставленную задача. 









