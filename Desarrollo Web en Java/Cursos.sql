CREATE DATABASE web;

USE web;

CREATE TABLE Cursos (
nombre VARCHAR(30),
nivel int);

create table users (
  user_name         varchar(15) not null primary key,
  user_pass         varchar(15) not null
);

create table user_roles (
  user_name         varchar(15) not null,
  role_name         varchar(25) not null,
  primary key (user_name, role_name)
);

INSERT INTO users (user_name,user_pass) VALUES("ismael3","ismael3");
INSERT INTO user_roles (user_name,role_name) VALUES("ismael3","usuarioAdministrador");

DROP TABLE user_roles;

select * from cursos;
