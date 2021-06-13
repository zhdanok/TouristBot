# заполнение БД

INSERT INTO city_info (info_id, info) VALUES (1, 'Красная Площадь по прежнему в фаворитах!');
INSERT INTO city_info (info_id, info) VALUES (2, 'В хорошую погоду прогуляйтесть в Центральном парке, в плохую - отправляйтесь в Метрополитен-музей');
INSERT INTO city_info (info_id, info) VALUES (3, 'Невозможно пропустить: Тауэрский мост и Биг-Бен!');
INSERT INTO city_info (info_id, info) VALUES (4, 'Днем вас ждут Елисейские поля, а вечером - смотровая платформа Эйфилевой башни');
INSERT INTO city_info (info_id, info) VALUES (5, 'Ни теряя ни минуты бегите в Храм "Изумрудного Будды". Он необычайно хорош)');
INSERT INTO city_info (info_id, info) VALUES (6, 'Надеемся вы не боитесь высоты, потому что у нас для вас обзорная площадка  на 148 этаже башни Бурдж-Халифа');
INSERT INTO city_info (info_id, info) VALUES (7, 'Если устали от мечетей - отправляйтесь на Гранд-Базар в самом центре Стамбула. Порадуются и глаз и желудок)');
INSERT INTO city_info (info_id, info) VALUES (8, 'Здесь оочень много дворцов! Но мы предлагаем начать с Дворца Чхангёнгун');

INSERT INTO city_en VALUES
(1, 'Moscow', 1),
(2, 'New-York', 2),
(3, 'London', 3),
(4, 'Paris', 4),
(5, 'Bangkok', 5),
(6, 'Dubai', 6),
(7, 'Istanbul', 7),
(8, 'Seoul', 8);

INSERT INTO city_ru (id_ru, name_ru, info_id) VALUES (1, 'Москва', 1);
INSERT INTO city_ru (id_ru, name_ru, info_id) VALUES (2, 'Нью-Йорк', 2);
INSERT INTO city_ru (id_ru, name_ru, info_id) VALUES (3, 'Лондон', 3);
INSERT INTO city_ru (id_ru, name_ru, info_id) VALUES (4, 'Париж', 4);
INSERT INTO city_ru (id_ru, name_ru, info_id) VALUES (5, 'Бангкок', 5);
INSERT INTO city_ru (id_ru, name_ru, info_id) VALUES (6, 'Дубаи', 6);
INSERT INTO city_ru (id_ru, name_ru, info_id) VALUES (7, 'Стамбул', 7);
INSERT INTO city_ru (id_ru, name_ru, info_id) VALUES (8, 'Сеул', 8);


# создание БД
CREATE DATABASE guide
    DEFAULT CHARACTER SET utf8
    DEFAULT COLLATE utf8_general_ci;

# запрос на английском
SELECT name_en, info FROM city_en
JOIN city_info ci on ci.info_id = city_en.info_id;

# запрос на русском
SELECT name_ru, info FROM city_ru
JOIN city_info ci on ci.info_id = city_ru.info_id;