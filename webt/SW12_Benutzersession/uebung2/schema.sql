create database tasks;

use tasks;

create table users(login varchar(200), hash varchar(200));

create unique index users_unique on users(login);

create table tasks(user varchar(200), task varchar(1000));

insert into tasks (user, task) values ('jack', 'Hausaufgaben fuer Dienstag erledigen');
insert into tasks (user, task) values ('kim', 'Projektarbeit fertigstellen');
insert into tasks (user, task) values ('luke', 'Auto waschen');
insert into tasks (user, task) values ('joe', 'Geburtstagsparty organisieren');
insert into tasks (user, task) values ('kim', 'Unittests schreiben');
insert into tasks (user, task) values ('jack', 'Hausaufgaben fuer Donnerstag erledigen');
