DROP DATABASE PencaUCU;
CREATE DATABASE PencaUCU;
USE PencaUCU;

CREATE TABLE Estudiante (
    idUsuario INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL ,
    email VARCHAR(50) NOT NULL,
    contrasena VARCHAR(50) NOT NULL,
    carrera VARCHAR(50) NOT NULL,
    PRIMARY KEY (idUsuario)
);

CREATE TABLE Administrador (
    idAdmin INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL ,
    email VARCHAR(50) NOT NULL,
    contrasena VARCHAR(50) NOT NULL,
    PRIMARY KEY (idAdmin)
);

CREATE TABLE Seleccion(
                          nombre VARCHAR(50) NOT NULL,
                          PRIMARY KEY (nombre)
);

CREATE TABLE Partido(
                        nombreSeleccionLocal varchar(50) NOT NULL ,
                        nombreSeleccionVisitante varchar(50) NOT NULL ,
                        fecha DATETIME,
                        golLocal INT,
                        golVisitante INT,
                        PRIMARY KEY (nombreSeleccionLocal,nombreSeleccionVisitante, fecha),
                        FOREIGN KEY (nombreSeleccionLocal) REFERENCES Seleccion(nombre),
                        FOREIGN KEY (nombreSeleccionVisitante) REFERENCES Seleccion(nombre)
);

CREATE TABLE Estudiante_Realiza_Prediccion(
    idUsuario INT,
    idPrediccion INT,
    nombreSeleccionLocal varchar(50) NOT NULL ,
    nombreSeleccionVisitante varchar(50) NOT NULL ,
    golLocal INT,
    golVisitante INT,
    PRIMARY KEY (idUsuario,idPrediccion),
    FOREIGN KEY (idUsuario ) REFERENCES Estudiante(idUsuario),
    FOREIGN KEY (nombreSeleccionLocal, nombreSeleccionVisitante) REFERENCES Partido(nombreSeleccionLocal, nombreSeleccionVisitante)
);

CREATE TABLE Estudiante_Elige_Seleccion(
                                           idUsuario INT NOT NULL,
                                           nombreSeleccion varchar(50) NOT NULL,
                                           campeon ENUM ('Campeón', 'Subcampeón') NOT NULL,
                                           PRIMARY KEY (idUsuario, nombreSeleccion),
                                           FOREIGN KEY (idUsuario) REFERENCES Estudiante(idUsuario),
                                           FOREIGN KEY (nombreSeleccion) REFERENCES Seleccion(nombre)
);

INSERT INTO Estudiante (idUsuario, nombre, email, contrasena, carrera) VALUE (1,'Maria','maria@madas.com','1234','Ingeniería en Informática');

INSERT INTO Administrador (idAdmin, nombre, email, contrasena) VALUE (0,'Administrador','admin@gmail.com','4321');

INSERT INTO Seleccion(nombre) VALUES
('Argentina'),
('Bolivia'),
('Brasil'),
('Canadá'),
('Chile'),
('Colombia'),
('Costa Rica'),
('Ecuador'),
('Jamaica'),
('México'),
('Panamá'),
('Paraguay'),
('Peru'),
('United States'),
('Uruguay'),
('Venezuela');

INSERT INTO Partido (nombreSeleccionLocal, nombreSeleccionVisitante, fecha, golLocal, golVisitante) VALUES
('Argentina', 'Canadá', '2024-06-20', NULL, NULL),
('Peru', 'Chile', '2024-06-21', NULL, NULL),
('Ecuador', 'Venezuela', '2024-06-22', NULL, NULL),
('México', 'Jamaica', '2024-06-22', NULL, NULL),
('United States', 'Bolivia', '2024-06-23', NULL, NULL),
('Uruguay', 'Panamá', '2024-06-23', NULL, NULL),
('Colombia', 'Paraguay', '2024-06-24', NULL, NULL),
('Brasil', 'Costa Rica', '2024-06-24', NULL, NULL),
('Peru', 'Canadá', '2024-06-25', NULL, NULL),
('Chile', 'Argentina', '2024-06-25', NULL, NULL),
('Ecuador', 'Jamaica', '2024-06-26', NULL, NULL),
('Venezuela', 'México', '2024-06-26', NULL, NULL),
('Panamá', 'United States', '2024-06-27', NULL, NULL),
('Uruguay', 'Bolivia', '2024-06-27', NULL, NULL),
('Colombia', 'Costa Rica', '2024-06-28', NULL, NULL),
('Paraguay', 'Brasil', '2024-06-28', NULL, NULL),
('Argentina', 'Peru', '2024-06-29', NULL, NULL),
('Canadá', 'Chile', '2024-06-29', NULL, NULL),
('Jamaica', 'Venezuela', '2024-06-30', NULL, NULL),
('México', 'Ecuador', '2024-06-30', NULL, NULL),
('United States', 'Uruguay', '2024-07-01', NULL, NULL),
('Bolivia', 'Panamá', '2024-07-01', NULL, NULL),
('Brasil', 'Colombia', '2024-07-02', NULL, NULL),
('Costa Rica', 'Paraguay', '2024-07-02', NULL, NULL);

INSERT INTO Estudiante_Realiza_Prediccion(idUsuario, idPrediccion, nombreSeleccionLocal, nombreSeleccionVisitante, golLocal, golVisitante) VALUE (1, 1, 'Argentina', 'Canadá', 0, 3);

INSERT INTO Estudiante_Elige_Seleccion(idUsuario, nombreSeleccion, campeon) VALUE (1,'Argentina','Campeón');

INSERT INTO Estudiante_Elige_Seleccion(idUsuario, nombreSeleccion, campeon) VALUE (1,'Brasil','Subcampeón');


