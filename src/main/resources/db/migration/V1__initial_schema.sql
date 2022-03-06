DROP TABLE IF EXISTS refugees;
DROP TABLE IF EXISTS volunteers;
DROP TABLE IF EXISTS languages;
DROP TABLE IF EXISTS needs;

create table refugee_languages
(
    refugee_id uuid    not null,
    code       varchar not null,
    PRIMARY KEY (refugee_id, code)
);

create table citizenships
(
    country_code    varchar primary key,
    value           varchar not null unique
);

create table needs
(
    id    uuid primary key,
    code  varchar not null unique,
    value varchar not null
);

create table refugee_need
(
    refugee_id uuid not null,
    need_id    uuid not null,
    PRIMARY KEY (refugee_id, need_id)
);

create table volunteers
(
    id       uuid primary key,
    fullName varchar not null,
    contact  varchar not null
);

CREATE TABLE refugees
(
    id                 uuid primary key,
    full_name          varchar                  not null,
    date_of_birth      date                     not null,
    gender             varchar                  not null,
    citizenship        varchar                  not null,
    phone_number       varchar                  not null,
    number_of_adults   integer                  not null,
    number_of_children integer                  not null,
    has_animals        boolean default false    not null,
    current_location   varchar                  not null,
    target_location    varchar,
    description        varchar,
    created_at         timestamp with time zone not null,
    updated_at         timestamp with time zone not null,
    status             varchar default 'NEW'    not null,
    volunteer_id       uuid,
    constraint refugees_volunteers_fk
        foreign key (volunteer_id)
            references volunteers (id)
);
-- ALTER TABLE refugees
--     ALTER COLUMN languages SET DEFAULT array []::varchar[];
-- ALTER TABLE refugees
--     ALTER COLUMN needs SET DEFAULT array []::varchar[];