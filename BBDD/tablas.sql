CREATE TABLE marca(
    id_marca INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    sede VARCHAR(100) NOT NULL,
    pais VARCHAR(100) NOT NULL,
    activa BOOLEAN NOT NULL DEFAULT 0
);

CREATE TABLE produce(
    marca INT NOT NULL,
    cerveza INT NOT NULL,
    PRIMARY KEY (marca, cerveza),
    FOREIGN KEY(marca) REFERENCES marca(id_marca),
    FOREIGN KEY(cerveza) REFERENCES cerveza(id_cerveza)
);

CREATE TABLE cerveza(
    id_cerveza INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    graduacion FLOAT NOT NULL,
    precio FLOAT NOT NULL,
    activa BOOLEAN NOT NULL DEFAULT 0
);

CREATE TABLE asociada(
    factura INT NOT NULL,
    cerveza INT NOT NULL,
    cantidad INT NOT NULL,
    precio FLOAT NOT NULL,
    PRIMARY KEY (factura, cerveza),
    FOREIGN KEY(factura) REFERENCES factura(id_factura),
    FOREIGN KEY(cerveza) REFERENCES cerveza(id_cerveza)
);

CREATE TABLE factura(
    id_factura INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    precio_total FLOAT NOT NULL,
    empleado INT NOT NULL,
    PRIMARY KEY (id_factura),
    FOREIGN KEY(empleado) REFERENCES empleado(id_empleado),
);

CREATE TABLE empleado(
    id_empleado INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    telefono VARCHAR(9) NOT NULL,
    tiempo_completo BOOLEAN NOT NULL DEFAULT 0,
    PRIMARY KEY (id_empleado)
);
