export class Prediccion {
    idEstudiante: number = 1;
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

    constructor(nombreSeleccionLocal: string, nombreSeleccionVisitante: string, fechaPartido: Date,
        golLocal: number, golVisitante: number, puntaje:number) {
        this.nombreSeleccionLocal = nombreSeleccionLocal;
        this.nombreSeleccionVisitante = nombreSeleccionVisitante;
        this.fechaPartido = fechaPartido;
        this.golLocal = golLocal;
        this.golVisitante = golVisitante;
        this.puntaje = puntaje;
    }
}