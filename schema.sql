create table posts
(
    id         int auto_increment
        primary key,
    author     varchar(255)                        not null,
    title      varchar(255)                        not null,
    content    mediumtext                          not null,
    created_at timestamp default CURRENT_TIMESTAMP null
);

create table comments
(
    id         int auto_increment
        primary key,
    author     varchar(255)                        not null,
    content    text                                not null,
    post_id    int                                 null,
    created_at timestamp default CURRENT_TIMESTAMP null,
    constraint comments_posts__fk
        foreign key (post_id) references posts (id)
            on delete cascade
);

