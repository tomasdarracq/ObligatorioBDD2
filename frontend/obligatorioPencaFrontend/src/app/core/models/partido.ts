export class Partido {
    seleccionLocalNombre!: string;
    seleccionVisitanteNombre!: string;
    fecha!: Date;
    dia?: string;
    horario?: string;
    golesLocal?: number;
    golesVisitante?: number;
    id: number = 0;

    constructor(seleccionLocalNombre: string, seleccionVisitanteNombre: string, fecha: Date,
        golesLocal: number, golesVisitante: number, dia?: string, horario?: string) {

        this.seleccionLocalNombre = seleccionLocalNombre;
        this.seleccionVisitanteNombre = seleccionVisitanteNombre;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.dia = dia;
        this.horario = horario;
    }
}