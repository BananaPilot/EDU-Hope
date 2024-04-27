insert INTO user(password,username)
values
('cheballalavita','Carlo'),
('develz','VeroCoorinatrice'),
('NoAllaWebcam!25','H.Pasquale'),
('WilFramewokr875!','Banana'),
('Procio993','Coone'),
('dajeRoma','ILpupne'),
('ciaociao','Filippone');

insert Into user_registry(user_id,user_email,user_name,user_surname,user_telephone)
values
(1,'carlo@gmail.com','Carlo','lifecoach',347864182),
(2,'rame@gmail.com','Veronica','Ramez',348961527),
(3,'horses@gmail.com','Pasquale','Horses',350745631),
(4,'pilota@gmail.com','Fabio','Petros',347550674),
(5,'perdro@gmail.com','Pedro','FidatiDiME',34893142),
(6,'Amaggica@gmail.com','Francesco','Totti',349975211),
(7,'grazieRoma@gmail.com','Alesiio','Brazorf',348540774);

insert Into tutor(user_id)
values (1),(3);

insert into coordinator (user_id)
values (2);

insert into student (user_id)
values (4),(5),(6),(7);

insert into meeting(end_date,link,note,start_date,title)
values
('2024-04-16 05:30:00','mine.com','filosofia del piccone','2024-04-16 05:00:00','vita in miniera'),
('2024-04-16 23:30:00','horror.com','A cena con il truncate','2024-04-16 20:00:00','8500 row affected'),
('2024-04-17 23:30:00','horror.com','A cena con delete','2024-04-17 20:00:00','8000 row affected '),
('2024-04-18 11:30:00','love.com','appuntamento con i sentimenti introduzione','2024-04-18 10:00:00','Ciao come stai'),
('2024-04-14 11:30:00','love.com','appuntamento con i sentimenti','2024-04-16 10:00:00','mondo da scoppiati'),
('2024-04-15 13:30:00','youtube.com','canzoni rifalde','2024-04-16 10:00:00','mondo da scoppiati'),
('2024-04-16 13:30:00','youtube.com','il ballo del cavallo è facile è nu sball','2024-04-16 10:00:00','mondo da disoccupati');

insert into user_meeting(id_meeting, id_user)
values
(4,5),
(5,5),
(6,5),
(1,3),
(2,3),
(3,3),
(4,4),
(5,4),
(6,4),
(7,4),
(1,2),
(2,2),
(3,2),
(4,2),
(5,2),
(6,2),
(7,2),
(1,1),
(2,1),
(3,1),
(4,1),
(5,1),
(6,1),
(7,1);

insert into school(school_name)
values ('develhope');

insert into course (id_school, course_description, course_name)
values
(1, 'tuttafuffa', 'java_back_end'),
(1, 'blabla', 'full_stack'),
(1, 'blabla', 'front_end');

insert into class (id_coordinator, id_course, id_school, id_tutor, class_name)
values
(2, 1, 1, 3, 'java21'),
(2, 2, 1, 1, 'full_stack21');

insert into register(id_class, id_tutor, register_school_year)
values
(1, 3, '2024-05-01'),
(2, 1, '2024-05-01');

insert into vote(vote_date, vote_evaluation, id_register, id_student, annotation, vote_subject, is_check_point)
values
('2024-04-12', 7, 1, 4, 'benfatto', 'spring_boot', true),
('2024-04-12', 4, 2, 5, 'haifattoschifo', 'css', true);

insert into role(role_name) values ('SUPER_ADMIN'), ('ADMIN'), ('COORDINATOR'), ('STUDENT'), ('USER'), ('MODERATOR'), ('TUTOR');

insert into user_role(id_user, id_role)
    value ((select id from user where username = 'Banana'),
           (select id_role from role where role_name = 'SUPER_ADMIN'));
