export class Partido {
    seleccionLocal: string;
    seleccionVisitante: string;
    fecha: Date;
    golesLocal: number;
    golesVisitante: number;

    constructor(seleccionLocal: string, seleccionVisitante: string, fecha: Date, golesLocal: number, golesVisitante: number) {
        this.seleccionLocal = seleccionLocal;
        this.seleccionVisitante = seleccionVisitante;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }
}