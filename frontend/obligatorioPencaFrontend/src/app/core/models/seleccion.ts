export class Seleccion {
    nombre!: string;
    estado?: string;

    constructor(nombre: string, estado?: string) {
        this.nombre = nombre;
        this.estado = estado;
    }
}