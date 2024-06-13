export class Prediccion {
    idEstudiante: number;
    nombreSeleccionLocal!: string;
    nombreSeleccionVisitante!: string;
    fechaPartido!: Date;
    dia?: string;
    horario?: string;
    jugado?: boolean = false;
    golLocal!: number;
    golVisitante!: number;
    puntaje: number;
    id: number = 0;

    constructor(idEstudiante: number, nombreSeleccionLocal: string, nombreSeleccionVisitante: string, fechaPartido: Date,
        golLocal: number, golVisitante: number, puntaje: number) {
        this.idEstudiante = idEstudiante;
        this.nombreSeleccionLocal = nombreSeleccionLocal;
        this.nombreSeleccionVisitante = nombreSeleccionVisitante;
        this.fechaPartido = fechaPartido;
        this.golLocal = golLocal;
        this.golVisitante = golVisitante;
        this.puntaje = puntaje;
    }
}