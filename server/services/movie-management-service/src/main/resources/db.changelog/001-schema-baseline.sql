create table cinema
(
    id       bigserial not null,
    location varchar(255),
    name     varchar(255),
    primary key (id)
);
create table cinema_feedback
(
    id        bigserial not null,
    comment   varchar(255),
    score     int4,
    user_id   int8,
    cinema_id int8,
    primary key (id)
);
create table hall
(
    id        bigserial not null,
    name      varchar(255),
    cinema_id int8,
    primary key (id)
);
create table movie
(
    id          bigserial not null,
    description varchar(255),
    duration    int8,
    image_path  varchar(255),
    name        varchar(255),
    primary key (id)
);
create table movie_feedback
(
    id       bigserial not null,
    comment  varchar(255),
    score    int4,
    user_id  int8,
    movie_id int8,
    primary key (id)
);
create table place
(
    id           bigserial not null,
    place_number int8,
    row          int8,
    hall_id      int8,
    primary key (id)
);