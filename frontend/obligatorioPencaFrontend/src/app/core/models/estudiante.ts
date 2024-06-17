export class Estudiante {
    idEstudiante!: number;
    nombre!: string;
    email!: string;
    contrasena!: string;
    carrera!: string;  
    puntajeTotal!: number;

    constructor(idEstudiante: number, nombre: string, email: string, contrasena: string, carrera: string, puntajeTotal: number) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.carrera = carrera;
        this.puntajeTotal = puntajeTotal;
    }
}