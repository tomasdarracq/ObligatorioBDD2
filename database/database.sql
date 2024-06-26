DROP DATABASE IF EXISTS PencaUCU;
CREATE DATABASE PencaUCU CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE PencaUCU;
SET NAMES 'utf8mb4';

-- Crear tabla Estudiante
CREATE TABLE Estudiante (
    idEstudiante INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    contrasena VARCHAR(50) NOT NULL,
    carrera VARCHAR(50) NOT NULL,
    puntajeTotal INT,
    PRIMARY KEY (idEstudiante)
);

-- Crear tabla Administrador
CREATE TABLE Administrador (
    idAdmin INT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    contrasena VARCHAR(50) NOT NULL,
    PRIMARY KEY (idAdmin)
);

-- Crear tabla Seleccion
CREATE TABLE Seleccion (
    nombre VARCHAR(50) NOT NULL,
    estado VARCHAR(50),
    PRIMARY KEY (nombre)
);

-- Crear tabla Partido
CREATE TABLE Partido (
    nombreSeleccionLocal VARCHAR(50) NOT NULL,
    nombreSeleccionVisitante VARCHAR(50) NOT NULL,
    fecha DATETIME NOT NULL,
    golLocal INT,
    golVisitante INT,
    PRIMARY KEY (nombreSeleccionLocal, nombreSeleccionVisitante, fecha),
    FOREIGN KEY (nombreSeleccionLocal) REFERENCES Seleccion(nombre),
    FOREIGN KEY (nombreSeleccionVisitante) REFERENCES Seleccion(nombre)
);

-- Crear tabla Estudiante_Realiza_Prediccion
CREATE TABLE Estudiante_Realiza_Prediccion (
    idEstudiante INT,
    nombreSeleccionLocal VARCHAR(50) NOT NULL,
    nombreSeleccionVisitante VARCHAR(50) NOT NULL,
    fecha DATETIME NOT NULL,
    golLocal INT,
    golVisitante INT,
    puntaje INT,
    PRIMARY KEY (idEstudiante, nombreSeleccionLocal, nombreSeleccionVisitante, fecha),
    FOREIGN KEY (idEstudiante) REFERENCES Estudiante(idEstudiante),
    FOREIGN KEY (nombreSeleccionLocal, nombreSeleccionVisitante, fecha) REFERENCES Partido(nombreSeleccionLocal, nombreSeleccionVisitante, fecha)
);

-- Crear tabla Estudiante_Elige_Seleccion
CREATE TABLE Estudiante_Elige_Seleccion (
    idEstudiante INT NOT NULL,
    nombreSeleccion VARCHAR(50) NOT NULL,
    eleccion VARCHAR(50) NOT NULL,
    PRIMARY KEY (idEstudiante, nombreSeleccion),
    FOREIGN KEY (idEstudiante) REFERENCES Estudiante(idEstudiante),
    FOREIGN KEY (nombreSeleccion) REFERENCES Seleccion(nombre)
);

-- Insertar datos en la tabla Estudiante
INSERT INTO Estudiante (idEstudiante, nombre, email, contrasena, carrera) VALUES
(1, 'Diego', 'handalian.diego11@gmail.com', '4321', 'Ingeniería en Informática'),
(2, 'Juan', 'juan@gmail.com', '1111', 'Ingeniería en Informática'),
(3, 'Sebastián', 'sebamart12@gmail.com', '2222', 'Ingeniería en Informática');

-- Insertar datos en la tabla Administrador
INSERT INTO Administrador (idAdmin, nombre, email, contrasena) VALUES
(0, 'Administrador', 'admin@gmail.com', '4321');

-- Insertar datos en la tabla Seleccion
INSERT INTO Seleccion (nombre) VALUES
('Argentina'),
('Bolivia'),
('Brasil'),
('Canadá'),
('Chile'),
('Colombia'),
('Costa Rica'),
('Ecuador'),
('Estados Unidos'),
('Jamaica'),
('México'),
('Panamá'),
('Paraguay'),
('Perú'),
('Uruguay'),
('Venezuela');

-- Insertar datos en la tabla Partido
INSERT INTO Partido (nombreSeleccionLocal, nombreSeleccionVisitante, fecha, golLocal, golVisitante) VALUES
('Argentina', 'Canadá', '2024-06-20 21:00:00', NULL, NULL),
('Perú', 'Chile', '2024-06-21 21:00:00', NULL, NULL),
('Ecuador', 'Venezuela', '2024-06-22 19:00:00', NULL, NULL),
('México', 'Jamaica', '2024-06-22 22:00:00', NULL, NULL),
('Estados Unidos', 'Bolivia', '2024-06-23 19:00:00', NULL, NULL),
('Uruguay', 'Panamá', '2024-06-23 22:00:00', NULL, NULL),
('Colombia', 'Paraguay', '2024-06-24 19:00:00', NULL, NULL),
('Brasil', 'Costa Rica', '2024-06-24 22:00:00', NULL, NULL),
('Perú', 'Canadá', '2024-06-25 19:00:00', NULL, NULL),
('Chile', 'Argentina', '2024-06-25 22:00:00', NULL, NULL),
('Ecuador', 'Jamaica', '2024-06-26 19:00:00', NULL, NULL),
('Venezuela', 'México', '2024-06-26 22:00:00', NULL, NULL),
('Panamá', 'Estados Unidos', '2024-06-27 19:00:00', NULL, NULL),
('Uruguay', 'Bolivia', '2024-06-27 22:00:00', NULL, NULL),
('Colombia', 'Costa Rica', '2024-06-28 19:00:00', NULL, NULL),
('Paraguay', 'Brasil', '2024-06-28 22:00:00', NULL, NULL),
('Argentina', 'Perú', '2024-06-29 21:00:00', NULL, NULL),
('Canadá', 'Chile', '2024-06-29 21:00:00', NULL, NULL),
('Jamaica', 'Venezuela', '2024-06-30 21:00:00', NULL, NULL),
('México', 'Ecuador', '2024-06-30 21:00:00', NULL, NULL),
('Estados Unidos', 'Uruguay', '2024-07-01 22:00:00', NULL, NULL),
('Bolivia', 'Panamá', '2024-07-01 22:00:00', NULL, NULL),
('Brasil', 'Colombia', '2024-07-02 22:00:00', NULL, NULL),
('Costa Rica', 'Paraguay', '2024-07-02 22:00:00', NULL, NULL);

-- Insertar datos en la tabla Estudiante_Realiza_Prediccion
INSERT INTO Estudiante_Realiza_Prediccion (idEstudiante, nombreSeleccionLocal, nombreSeleccionVisitante, fecha, golLocal, golVisitante, puntaje) VALUES
(1, 'Argentina', 'Canadá', '2024-06-20 21:00:00', 2, 0, 0),
(1, 'Perú', 'Chile', '2024-06-21 21:00:00', 0, 0, 0),
(1, 'Ecuador', 'Venezuela', '2024-06-22 19:00:00', 1, 2, 0),
(1, 'México', 'Jamaica', '2024-06-22 22:00:00', 1, 0, 0),
(1, 'Estados Unidos', 'Bolivia', '2024-06-23 19:00:00', 2, 0, 0),
(1, 'Uruguay', 'Panamá', '2024-06-23 22:00:00', 3, 1, 0),
(1, 'Colombia', 'Paraguay', '2024-06-24 19:00:00', 1, 0, 0),
(1, 'Brasil', 'Costa Rica', '2024-06-24 22:00:00', 0, 0, 0),
(1, 'Perú', 'Canadá', '2024-06-25 19:00:00', 0, 1, 0),
(1, 'Chile', 'Argentina', '2024-06-25 22:00:00', 0, 1, 0),
(2, 'Argentina', 'Canadá', '2024-06-20 21:00:00', 0, 0, 0),
(2, 'Perú', 'Chile', '2024-06-21 21:00:00', 0, 1, 0),
(2, 'Ecuador', 'Venezuela', '2024-06-22 19:00:00', 1, 5, 0),
(2, 'México', 'Jamaica', '2024-06-22 22:00:00', 3, 0, 0),
(3, 'Estados Unidos', 'Bolivia', '2024-06-23 19:00:00', 2, 0, 0),
(3, 'Perú', 'Chile', '2024-06-21 21:00:00', 0, 7, 0),
(3, 'Ecuador', 'Venezuela', '2024-06-22 19:00:00', 2, 5, 0),
(3, 'México', 'Jamaica', '2024-06-22 22:00:00', 3, 6, 0);

-- Insertar datos en la tabla Estudiante_Elige_Seleccion
INSERT INTO Estudiante_Elige_Seleccion (idEstudiante, nombreSeleccion, eleccion) VALUES
(1, 'Uruguay', 'Campeón'),
(1, 'Argentina', 'Subcampeón');
