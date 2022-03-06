insert into refugee_languages(refugee_id, code)
values ('b2cce6e4-413b-406a-901a-5ca9c2ce950b', 'uk'),
       ('b2cce6e4-413b-406a-901a-5ca9c2ce950b', 'en'),
       ('b2cce6e4-413b-406a-901a-5ca9c2ce950b', 'pl'),
       ('b2cce6e4-413b-406a-901a-5ca9c2ce950b', 'ru');

insert into citizenships(country_code, value)
values ('UA', 'Ukraine');

insert into needs (id, code, value)
values ('0e6c7393-67a2-45d6-96c8-d01f510fc6f7', 'TRANSPORT', 'Помощь с транспортом'),
       ('fe6d7476-9d22-11ec-b909-0242ac120002', 'ACCOMMODATION', 'Помощь с размещением');

insert into refugee_need(refugee_id, need_id)
values ('b2cce6e4-413b-406a-901a-5ca9c2ce950b', '0e6c7393-67a2-45d6-96c8-d01f510fc6f7');

insert into volunteers(id, fullname, contact)
values ('1991b1e0-e3e7-4185-9a24-496d61aa7fa2', 'Jan Kowalski', '+48000000000');

insert into refugees
(id, full_name, date_of_birth, gender,
 citizenship, phone_number,
 number_of_adults, number_of_children, has_animals,
 current_location, target_location,
 description, created_at, updated_at,
 status, volunteer_id)
values ('b2cce6e4-413b-406a-901a-5ca9c2ce950b', 'Iwan Iwanowich Iwanow', '1980-01-01', 'men',
        'UA', '+48000000001',
        2, 1, true,
        'Przemysl', 'Warsaw',
        'lorem ipsum', timestamp '2022-02-01 15:00:00', now(),
        'NEW', '1991b1e0-e3e7-4185-9a24-496d61aa7fa2');