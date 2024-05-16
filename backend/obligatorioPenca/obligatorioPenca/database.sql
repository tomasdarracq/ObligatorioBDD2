Create table Usuario(
                        idUsuario int NOT NULL AUTO_INCREMENT,
                        nombre varchar(50) not null ,
                        email varchar(50) not null,
                        contrasena varchar(50) not null,
                        tipo varchar(50) not null,
                        PRIMARY KEY (idUsuario)
);
CREATE TABLE Prediccion(
                           idPrediccion int NOT NULL AUTO_INCREMENT,
                           primary key (idPrediccion)

);
CREATE TABLE Estudiante_Realiza_Prediccion(
                                              idUsuario int,
                                              idPrediccion int,
                                              goles_local int,
                                              goles_visitante int,
                                              primary key (idUsuario,idPrediccion),
                                              foreign key (idUsuario ) references Usuario( idUsuario),
                                              foreign key (idPrediccion ) references Prediccion( idPrediccion)
);
CREATE TABLE Seleccion(
                          idSeleccion int NOT NULL AUTO_INCREMENT,
                          nombre varchar(50) not null,
                          primary key (idSeleccion)
);
CREATE TABLE Partido(
                        idSeleccionLocal int NOT NULL ,
                        idSeleccionVisitante int NOT NULL ,
                        fecha date ,
                        golLocal varchar(50),
                        golVisitante varchar(50),
                        primary key (idSeleccionLocal,idSeleccionVisitante, fecha),
                        foreign key (idSeleccionLocal) references Seleccion(idSeleccion),
                        foreign key (idSeleccionVisitante) references Seleccion(idSeleccion)
);
CREATE TABLE Selecciones_Tiene_Prediccion (
                                              idPrediccion int NOT NULL,
                                              idSeleccion1 int NOT NULL,
                                              idSeleccion2 int NOT NULL,
                                              fecha date NOT NULL,
                                              PRIMARY KEY (idPrediccion, idSeleccion1, idSeleccion2, fecha),
                                              FOREIGN KEY (idSeleccion1, idSeleccion2, fecha) REFERENCES Partido(idSeleccionLocal, idSeleccionVisitante, fecha),
                                              FOREIGN KEY (idPrediccion) REFERENCES Prediccion(idPrediccion)
);
CREATE TABLE Estudiante_Elige_Seleccion(
                                           idUsuario int NOT NULL,
                                           idSeleccion int NOT NULL,
                                           tipo varchar(50),
                                           PRIMARY KEY (idUsuario, idSeleccion),
                                           foreign key (idUsuario) references Usuario(idUsuario),
                                           foreign key (idSeleccion) references Seleccion(idSeleccion)
);

INSERT INTO Usuario (idUsuario, nombre, email, contrasena, tipo) VALUE (1,'Maria','maria@madas.com','1234','Administrador');
INSERT INTO Prediccion(idPrediccion) value (1);
INSERT INTO Estudiante_Realiza_Prediccion(idUsuario, idPrediccion, goles_local, goles_visitante) VALUE (1,1,0,3);
INSERT INTO Seleccion(idSeleccion, nombre) VALUE (1,'Uruguay');
INSERT INTO Seleccion(idSeleccion, nombre) VALUE (2,'Argentina');
INSERT INTO Partido (idSeleccionLocal, idSeleccionVisitante, fecha, golLocal, golVisitante) VALUE (1,2,'2024-06-01',2,1);
INSERT INTO Selecciones_Tiene_Prediccion(idPrediccion, idSeleccion1, idSeleccion2, fecha) VALUE (1,1,2,'2024-06-01');
INSERT INTO Estudiante_Elige_Seleccion(idUsuario, idSeleccion, tipo) VALUE (1,1,'Campeon');
INSERT INTO Estudiante_Elige_Seleccion(idUsuario, idSeleccion, tipo) VALUE (1,2,'Subcampeon');


