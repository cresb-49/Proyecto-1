CREATE SCHEMA IF NOT EXISTS mi_empresa_proyecto1;

USE mi_empresa_proyecto1;

CREATE TABLE IF NOT EXISTS TIENDA(
    codigo VARCHAR(15) NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    telefono_1 VARCHAR(8) NOT NULL,
    telefono_2 VARCHAR(8),
    email VARCHAR(20),
    horario VARCHAR(100),
    PRIMARY KEY (codigo),
    UNIQUE (codigo)
);

CREATE TABLE IF NOT EXISTS CLIENTE (
    nit VARCHAR(10) NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    telefono VARCHAR(8) NOT NULL,
    credito DOUBLE,
    dpi VARCHAR(10),
    email VARCHAR(30),
    direccion VARCHAR(100),
    PRIMARY KEY (nit),
    UNIQUE (nit,dpi)
);

CREATE TABLE IF NOT EXISTS EMPLEADO (
    codigo VARCHAR(20) NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    telefono VARCHAR(8) NOT NULL,
    dpi VARCHAR(10) NOT NULL,
    nit VARCHAR(20),
    email VARCHAR(30) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    PRIMARY KEY (codigo),
    UNIQUE (codigo,dpi,nit)
);

CREATE TABLE IF NOT EXISTS PRODUCTO(
    codigo VARCHAR(15) NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    fabricante VARCHAR(20) NOT NULL,
    precio DOUBLE NOT NULL,
    descripcion VARCHAR(100),
    garantia INT,
    PRIMARY KEY (codigo),
    UNIQUE (codigo)
);
CREATE TABLE IF NOT EXISTS EXISTENCIA(
    id INT NOT NULL AUTO_INCREMENT,
    TIENDA_codigo VARCHAR(15) NOT NULL,
    PRODUCTO_codigo VARCHAR(15) NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (id),
    FOREIGN KEY (TIENDA_codigo) REFERENCES TIENDA(codigo),
    FOREIGN KEY (PRODUCTO_codigo) REFERENCES PRODUCTO(codigo)
);

CREATE TABLE IF NOT EXISTS PEDIDO(
    id INT NOT NULL AUTO_INCREMENT,
    codigo VARCHAR(15) NOT NULL,
    cantidad INT NOT NULL,
    total DOUBLE NOT NULL,
    anticipo DOUBLE NOT NULL,
    fecha_orden DATE NOT NULL,
    CLIENTE_nit VARCHAR(10) NOT NULL,
    PRODUCTO_codigo VARCHAR(15) NOT NULL,
    TIENDA_codigo_salida VARCHAR(15) NOT NULL,
    TIENDA_codigo_llegada VARCHAR(15) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (CLIENTE_nit) REFERENCES CLIENTE(nit),
    FOREIGN KEY (PRODUCTO_codigo) REFERENCES PRODUCTO(codigo),
    FOREIGN KEY (TIENDA_codigo_salida) REFERENCES TIENDA(codigo),
    FOREIGN KEY (TIENDA_codigo_llegada) REFERENCES TIENDA(codigo)
);

CREATE TABLE IF NOT EXISTS TIEMPO_TRASLADO(
    id INT NOT NULL AUTO_INCREMENT,
    TIENDA_codigo1 VARCHAR(15) NOT NULL,
    TIENDA_codigo2 VARCHAR(15) NOT NULL,
    tiempo INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (TIENDA_codigo1) REFERENCES TIENDA(codigo),
    FOREIGN KEY (TIENDA_codigo2) REFERENCES TIENDA(codigo)
);