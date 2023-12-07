CREATE DATABASE HELLEN1512BD;
USE  HELLEN1512BD;

CREATE TABLE usuarios(
idusuario INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30),
contraseña VARCHAR(30)
);
INSERT INTO USUARIOS VALUES(1,'admin','123')
;
CREATE TABLE categorias(
idcategoria INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30),
descripcion VARCHAR(30),
indicador CHAR(1)
);
CREATE TABLE materiales(
idmaterial INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30),
descripcion VARCHAR(30),
indicador CHAR(1)
);
CREATE TABLE colores(
idcolor INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30),
descripcion VARCHAR(30),
indicador CHAR(1)
);
CREATE TABLE productos(
idproducto INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30),
descripcion VARCHAR(30),
idcategoria INT,
idmaterial INT,
idcolor INT,
talla VARCHAR(10),
stock INT(10),
precio DECIMAL(10),
indicador CHAR(1)
);
DROP TABLE empleados;
CREATE TABLE empleados(
idempleado INT PRIMARY KEY AUTO_INCREMENT,
dni CHAR(8),
nombre VARCHAR(30),
apellido VARCHAR(30),
telefono VARCHAR(30),
correo VARCHAR(30),
sexo VARCHAR(1),
sueldo DECIMAL(10),
indicador CHAR(1)
);

CREATE TABLE clientes(
idcliente INT PRIMARY KEY AUTO_INCREMENT,
dni CHAR(8),
nombre VARCHAR(30),
apellido VARCHAR(30),
telefono VARCHAR(30),
correo VARCHAR(30),
sexo VARCHAR(1),
indicador CHAR(1)
);
CREATE TABLE pedidos(
idpedido INT PRIMARY KEY AUTO_INCREMENT,
idproducto INT,
idcliente INT,
idempleado INT,
fecha VARCHAR(30),
cantidad INT,
monto DECIMAL(10),
indicador CHAR(1)
);
CREATE TABLE ventas(
idventa INT PRIMARY KEY AUTO_INCREMENT,
idproducto INT,
idcliente INT,
idempleado INT,
fecha VARCHAR(30),
cantidad INT,
monto DECIMAL(10),
indicador CHAR(1)
);
-- Relaciones de la tabla productos
ALTER TABLE productos
ADD CONSTRAINT fk_categoria
FOREIGN KEY (idcategoria)
REFERENCES categorias(idcategoria);

ALTER TABLE productos
ADD CONSTRAINT fk_material
FOREIGN KEY (idmaterial)
REFERENCES materiales(idmaterial);

ALTER TABLE productos
ADD CONSTRAINT fk_color
FOREIGN KEY (idcolor)
REFERENCES colores(idcolor);

-- Relaciones de la tabla pedidos
ALTER TABLE pedidos
ADD CONSTRAINT fk_producto_pedido
FOREIGN KEY (idproducto)
REFERENCES productos(idproducto);

ALTER TABLE pedidos
ADD CONSTRAINT fk_cliente_pedido
FOREIGN KEY (idcliente)
REFERENCES clientes(idcliente);

ALTER TABLE pedidos
ADD CONSTRAINT fk_empleado_pedido
FOREIGN KEY (idempleado)
REFERENCES empleados(idempleado);

-- Relaciones de la tabla ventas
ALTER TABLE ventas
ADD CONSTRAINT fk_producto_venta
FOREIGN KEY (idproducto)
REFERENCES productos(idproducto);

ALTER TABLE ventas
ADD CONSTRAINT fk_cliente_venta
FOREIGN KEY (idcliente)
REFERENCES clientes(idcliente);

ALTER TABLE ventas
ADD CONSTRAINT fk_empleado_venta
FOREIGN KEY (idempleado)
REFERENCES empleados(idempleado);

DELIMITER //
CREATE TRIGGER actualizar_stock_despues_venta
AFTER INSERT ON ventas
FOR EACH ROW
BEGIN
    UPDATE productos
    SET stock = stock - NEW.cantidad
    WHERE idproducto = NEW.idproducto;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE InsertarProducto(
    IN p_nombre VARCHAR(30),
    IN p_descripcion VARCHAR(30),
    IN p_idcategoria INT,
    IN p_idmaterial INT,
    IN p_idcolor INT,
    IN p_talla VARCHAR(10),
    IN p_stock INT,
    IN p_precio DECIMAL(10)
)
BEGIN
    INSERT INTO productos (nombre, descripcion, idcategoria, idmaterial, idcolor, talla, stock, precio, indicador)
    VALUES (p_nombre, p_descripcion, p_idcategoria, p_idmaterial, p_idcolor, p_talla, p_stock, p_precio, '1');
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE ConsultarProducto(
    IN p_idproducto INT
)
BEGIN
    SELECT * FROM productos WHERE idproducto = p_idproducto;
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE ActualizarProducto(
    IN p_idproducto INT,
    IN p_nuevo_nombre VARCHAR(30),
    IN p_nueva_descripcion VARCHAR(30),
    IN p_nueva_idcategoria INT,
    IN p_nueva_idmaterial INT,
    IN p_nueva_idcolor INT,
    IN p_nueva_talla VARCHAR(10),
    IN p_nuevo_stock INT,
    IN p_nuevo_precio DECIMAL(10)
)
BEGIN
    UPDATE productos
    SET
        nombre = p_nuevo_nombre,
        descripcion = p_nueva_descripcion,
        idcategoria = p_nueva_idcategoria,
        idmaterial = p_nueva_idmaterial,
        idcolor = p_nueva_idcolor,
        talla = p_nueva_talla,
        stock = p_nuevo_stock,
        precio = p_nuevo_precio
    WHERE idproducto = p_idproducto;
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE EliminarProducto(
    IN p_idproducto INT
)
BEGIN
    DELETE FROM productos WHERE idproducto = p_idproducto;
END //
DELIMITER ;


