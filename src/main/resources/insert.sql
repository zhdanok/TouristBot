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

INSERT INTO city VALUES
('Москва', 'Moscow', 1),
('Нью-Йорк', 'New-York', 2),
('Лондон', 'London', 3),
('Париж', 'Paris', 4),
('Бангкок', 'Bangkok', 5),
('Дубаи', 'Dubai', 6),
('Стамбул', 'Istanbul', 7),
('Сеул', 'Seoul', 8);


# создание БД
CREATE DATABASE guide
    DEFAULT CHARACTER SET utf8
    DEFAULT COLLATE utf8_general_ci;


SELECT info FROM city_info
                     JOIN city c on city_info.info_id = c.info_id
WHERE name_ru like '%Москва%' OR name_en like '%Moscow%';