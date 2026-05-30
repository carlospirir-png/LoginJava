create database Usuario;
use Usuario;

create table Login(
ID INT PRIMARY KEY auto_increment,
Nombre varchar(200),
Correo varchar(250),
Contraseña varchar(100)
);

select * from Login;

