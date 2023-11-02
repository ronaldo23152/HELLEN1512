-- Creación de la base de datos "HELLEN1512"
CREATE DATABASE HELLEN1512;
USE HELLEN1512;
CREATE TABLE usuarios(
idusuario INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30),
contraseña VARCHAR(30)
);
CREATE TABLE categorias(
idcategoria INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30),
indicador CHAR(1)
);
CREATE TABLE materiales(
idmaterial INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30),
indicador CHAR(1)
);
CREATE TABLE colores(
idcolor INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30),
indicador CHAR(1)
);
CREATE TABLE productos(
idproducto INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30),
idcategoria INT,
idmaterial INT,
idcolor INT,
talla VARCHAR(10),
stock INT(10),
precio DECIMAL(10),
indicador CHAR(1),
FOREIGN KEY (idcategoria) REFERENCES categorias(idcategoria),
FOREIGN KEY (idmaterial) REFERENCES materiales(idmaterial),
FOREIGN KEY (idcolor) REFERENCES colores(idcolor)
);
CREATE TABLE empleados (
idempleado INT PRIMARY KEY AUTO_INCREMENT,
dni CHAR(8),
nombre VARCHAR(30),
cargo VARCHAR(30),
telefono CHAR(9),
correo VARCHAR(60) 
);
CREATE TABLE ventas (
idventa INT PRIMARY KEY AUTO_INCREMENT,
fecha DATE,
idempleado INT,
FOREIGN KEY (idempleado) REFERENCES empleados(idempleado)    
);
CREATE TABLE detalle_venta (
idventa INT,
idproducto INT,
cantidad INT,    
PRIMARY KEY (idventa, idproducto),
FOREIGN KEY (idventa) REFERENCES ventas(idventa),
FOREIGN KEY (idproducto) REFERENCES productos(idproducto)  
)    ;
CREATE TABLE pedidos (
idpedido INT PRIMARY KEY AUTO_INCREMENT,
fecha DATE,
idempleado INT,
FOREIGN KEY (idempleado) REFERENCES empleados(idempleado)   
);
CREATE TABLE detalle_pedido (
idpedido INT,
idproducto INT,
cantidad INT,
PRIMARY KEY (idpedido,idproducto) ,
FOREIGN KEY (idpedido) REFERENCES pedidos(idpedido) ,
FOREIGN KEY (idproducto) REFERENCES productos(idproducto) 
) ;

