create table if not exists user_role
(
    id_user bigint,
    id_role bigint,
    foreign key (id_role) references role (id_role),
    foreign key (id_user) references user (id),
    primary key (id_user, id_role)
);

create table if not exists user_meeting
(
    id_user bigint,
    id_meeting bigint,
    foreign key (id_user) references user(id),
    foreign key (id_meeting) references meeting (id_meeting),
    primary key (id_meeting, id_user)
);