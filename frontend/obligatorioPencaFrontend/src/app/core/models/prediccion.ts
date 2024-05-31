export class Prediccion {
    idEstudiante: number = 1;
    nombreSeleccionLocal!: string;
    nombreSeleccionVisitante!: string;
    fechaPartido!: Date;
    golLocal!: number;
    golVisitante!: number;
    puntaje: number = 0;

    constructor(nombreSeleccionLocal: string, nombreSeleccionVisitante: string, fechaPartido: Date,
        golLocal: number, golVisitante: number) {
        this.nombreSeleccionLocal = nombreSeleccionLocal;
        this.nombreSeleccionVisitante = nombreSeleccionVisitante;
        this.fechaPartido = fechaPartido;
        this.golLocal = golLocal;
        this.golVisitante = golVisitante;
    }
}