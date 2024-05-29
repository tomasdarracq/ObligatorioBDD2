export class Partido {
    seleccionLocalNombre: string;
    seleccionVisitanteNombre: string;
    fecha: Date;
    golesLocal: number;
    golesVisitante: number;

    constructor(seleccionLocalNombre: string, seleccionVisitanteNombre: string, fecha: Date, golesLocal: number, golesVisitante: number) {
        this.seleccionLocalNombre = seleccionLocalNombre;
        this.seleccionVisitanteNombre = seleccionVisitanteNombre;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }
}