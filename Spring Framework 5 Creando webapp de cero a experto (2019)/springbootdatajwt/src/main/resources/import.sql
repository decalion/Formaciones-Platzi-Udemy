/* Clientes */
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Ismael', 'Caballero', 'icanallero@test.com', '2019-07-01','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Cristian', 'Bautista', 'cbautistao@test.com', '2019-07-01','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Gerard', 'Exposito', 'gexposito@test.com', '2019-07-02','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Agusti', 'Montes', 'amontes@test.com', '2019-07-02','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Natalia', 'Exposito', 'nexposito@test.com', '2019-07-03','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Juan', 'Cebrian', 'jc@test.com', '2019-07-03','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Noemi', 'Garrigos', 'ngarrigos@test.com', '2019-07-03','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Alex', 'Griñon', 'agriñon@test.com', '2019-07-04','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Elisabeth', 'Martinez', 'emartinez@test.com', '2019-07-05','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Resha', 'Vanlentine', 'rvalentine@test.com', '2019-07-06','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Charlotte', 'springfield', 'csprinfield@test.com', '2019-07-07','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Homero', 'Simpson', 'hsimpson@test.com', '2019-07-07','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Goku', 'Kakaroto', 'gkakaroro@test.com', '2019-07-08','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Saitama', 'OnePunch', 'sonepunch@test.com', '2019-07-09','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Vegetta', 'sayain', 'vsayain@test.com', '2019-07-10','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Luffy', 'Monkey', 'lmonkey@test.com', '2019-07-10','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Natsu', 'Dragonail', 'ndragonaul@test.com', '2019-07-11','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Zaref', 'Dragonail', 'zdragonaul@test.com', '2019-07-11','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Lucy', 'Heartifilia', 'lheartifilia@test.com', '2019-07-12','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Haru', 'Glory', 'hglory@test.com', '2019-07-12','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Noel', 'Caralt', 'ncaralto@test.com', '2019-07-13','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Luis', 'Vicent', 'lvicent@test.com', '2019-07-14','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Noel', 'Riopedre', 'lriopedre@test.com', '2019-07-15','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('Alvaro', 'Santiago', 'asantiago@test.com', '2019-07-15','');
INSERT INTO clientes(nombre,apellido,email,create_at,foto) VALUES('pepe', 'pepeito', 'ppito@test.com', '2019-07-16','');


/*Producros */
INSERT INTO productos(nombre,precio,create_at)VALUES('Panasonic Pantalla LCD',259990,NOW());
INSERT INTO productos(nombre,precio,create_at)VALUES('Sony Camara Digital dsc-w320b',123490,NOW());
INSERT INTO productos(nombre,precio,create_at)VALUES('Apple iPod shuffle',1499990,NOW());
INSERT INTO productos(nombre,precio,create_at)VALUES('Sony Notebook Z110',37990,NOW());
INSERT INTO productos(nombre,precio,create_at)VALUES('Hewlett Packard Multifuncional',69990,NOW());
INSERT INTO productos(nombre,precio,create_at)VALUES('Bianchi Bicicleta Aro 26',259990,NOW());
INSERT INTO productos(nombre,precio,create_at)VALUES('Mica Comoda',2599,NOW());


/*Facturas */
INSERT INTO facturas(descripcion,observacion,cliente_id,create_at) VALUES ('Factura equipos de oficina',null,1,NOW());
INSERT INTO facturas_item(cantidad,factura_id,producto_id) VALUES (1,1,1);
INSERT INTO facturas_item(cantidad,factura_id,producto_id) VALUES (2,1,4);
INSERT INTO facturas_item(cantidad,factura_id,producto_id) VALUES (1,1,5);
INSERT INTO facturas_item(cantidad,factura_id,producto_id) VALUES (1,1,7);

INSERT INTO facturas(descripcion,observacion,cliente_id,create_at) VALUES ('Factura Bicicleta','alguna no importante!',1,NOW());
INSERT INTO facturas_item(cantidad,factura_id,producto_id) VALUES (3,2,6);



/*Users*/
INSERT INTO users (username, password, enable) VALUES ('ismael','$2a$10$7UhDfYUS7OWkXPfVfsMRM.TXQowdIahrum8.EeoQ/FfCvhywFaVMu',1);
INSERT INTO users (username, password, enable) VALUES ('admin','$2a$10$HXohJTAjTRSBtrycshkAueLCdUrr3j2TaqGfJRPL8HIYKz/v0WxhK',1);

/*Roles */
INSERT INTO authorities(user_id,authority) VALUES(1,'ROLE_USER');
INSERT INTO authorities(user_id,authority) VALUES(2,'ROLE_USER');
INSERT INTO authorities(user_id,authority) VALUES(2,'ROLE_ADMIN');




