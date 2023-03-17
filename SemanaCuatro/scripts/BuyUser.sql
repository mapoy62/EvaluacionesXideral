CREATE TABLE usuario (
    idusuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    correo VARCHAR(100)
);

-- Crear tabla Compra
CREATE TABLE compra (
    idcompra INT AUTO_INCREMENT PRIMARY KEY,
    num_prod INT,
    fecha DATE,
    total DECIMAL(10, 2),
    descuento DECIMAL(10, 2),
    idusuario INT,
    FOREIGN KEY (idusuario) REFERENCES usuario(idusuario)
);

insert into web_store_tracker.usuario values
(1,"Orlando","Pérez","orlan2@gmail.com"),
(2,"Virginia","Ocampo","virginia@gmail.com"),
(3,"Lucio","Silva","lucio@gmail.com"),
(4,"Gwendy","Ortiz","gwen@gmail.com");

insert into web_store_tracker.compra values
(1,4,'2023-03-05',1230.86,0.05,1),
(2,2,'2023-01-12',896,0.1,3),
(3,1,'2022-12-1',2630,0.5,2),
(4,1,'2022-12-05',548.5,0,1);

select * from usuario;
select * from compra;
select * from compra where idusuario=(select idusuario from usuario where idusuario=1);

select *
from compra c, usuario u
where u.idusuario = 4 && u.idusuario = c.idusuario;

select *
from compra c
where c.idusuario = 1 ;

insert into web_store_tracker.usuario values
(5,"Gwendy","Ortiz","gwen@gmail.com");

update compra 
set total = 54.5
where idcompra=6;

insert into web_store_tracker.compra values
(7,2,'2020-03-05',845.5,0.05,4);