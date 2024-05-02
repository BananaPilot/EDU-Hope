create table if not exists user_role
(
    id_user bigint,
    id_role bigint,
    foreign key (id_role) references role (id_role),
    foreign key (id_user) references user (id) on delete cascade,
    primary key (id_user, id_role)
);