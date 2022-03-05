insert into languages (id, code)
values ('0e6c7393-67a2-45d6-96c8-d01f510fc622', 'ua'),
       ('71567f10-365f-408b-8c23-cce34f2e9b33', 'en'),
       ('0e6c7393-67a2-45d6-96c8-d01f510fc644', 'pl'),
       ('0e6c7393-67a2-45d6-96c8-d01f510fc655', 'ru');

insert into needs (id, code)
values ('0e6c7393-67a2-45d6-96c8-d01f510fc6f7', 'TRANSPORT'),
       ('71567f10-365f-408b-8c23-cce34f2e9b81', 'ACCOMMODATION');

insert into volunteers(id, fullname, contact)
values ('1991b1e0-e3e7-4185-9a24-496d61aa7fa2', 'Jan Kowalski', '+48000000000');

insert into refugees
(id, full_name, date_of_birth, gender,
 languages, citizenship, phone_number,
 number_of_adults, number_of_children, animals,
 current_location, destination, needs,
 description, created_at, updated_at,
 status, volunteer_id)
values ('b2cce6e4-413b-406a-901a-5ca9c2ce950b', 'Iwan Iwanowich Iwanow', '1980-01-01', 'men',
        '{"ua"}', 'UA', '+48000000001',
        2, 1, true,
        'Przemysl', 'Warsaw', '{"0e6c7393-67a2-45d6-96c8-d01f510fc6f7"}',
        'lorem ipsum', timestamp '2022-02-01 15:00:00', now(),
        'NEW', '1991b1e0-e3e7-4185-9a24-496d61aa7fa2');