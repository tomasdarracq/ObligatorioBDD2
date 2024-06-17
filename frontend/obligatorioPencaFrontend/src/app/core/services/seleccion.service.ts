import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Seleccion } from '../models/seleccion';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SeleccionService {
  private apiUrl = 'http://localhost:8080/api/seleccion';
  selecciones: Seleccion[] = [];

  constructor(private http: HttpClient) { }

  getAllSelecciones(): Observable<Seleccion[]> {
    return this.http.get<Seleccion[]>(this.apiUrl);
  }

  obtenerAllSelecciones() {
    this.getAllSelecciones().subscribe(
      (equipos: Seleccion[]) => {
        this.selecciones = equipos; 
        console.log(this.selecciones);
      },
      (error) => console.log(error)
    );
  }
}
