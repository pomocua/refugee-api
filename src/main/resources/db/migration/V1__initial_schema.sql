DROP TABLE IF EXISTS refugees;
DROP TABLE IF EXISTS volunteers;
DROP TABLE IF EXISTS languages;
DROP TABLE IF EXISTS needs;

create table languages
(
    id   uuid primary key,
    code varchar not null unique
);

create table needs
(
    id   uuid primary key,
    code varchar not null unique
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
    languages          text[]                   not null,
    citizenship        varchar                  not null,
    phone_number       varchar                  not null,
    number_of_adults   integer                  not null,
    number_of_children integer                  not null,
    animals            boolean default false    not null,
    current_location   varchar                  not null,
    destination        varchar,
    needs              text[]                   not null,
    description        varchar,
    created_at         timestamp with time zone not null,
    updated_at         timestamp with time zone not null,
    status             varchar default 'NEW'    not null,
    volunteer_id       uuid,
    constraint refugees_volunteers_fk
        foreign key (volunteer_id)
            references volunteers (id)
);
ALTER TABLE refugees
    ALTER COLUMN languages SET DEFAULT array []::varchar[];
ALTER TABLE refugees
    ALTER COLUMN needs SET DEFAULT array []::varchar[];