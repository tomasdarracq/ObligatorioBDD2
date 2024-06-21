export class Finalista {
    idEstudiante!: number;
    nombreSeleccion!: string;
    eleccion!: string;

    constructor(idEstudiante: number, nombreSeleccion: string, eleccion: string) {
        this.idEstudiante = idEstudiante;
        this.nombreSeleccion = nombreSeleccion;
        this.eleccion = eleccion;
    }

}