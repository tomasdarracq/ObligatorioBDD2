import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Estudiante } from '../models/estudiante';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EstudianteService {

  private apiUrl = 'http://localhost:8080/api/estudiante';

  constructor(private http: HttpClient) { }
  
  getAllEstudiantes(): Observable<Estudiante[]> {
    return this.http.get<Estudiante[]>(this.apiUrl);
  }

  crearEstudiante(estudiante: Estudiante): Observable<Estudiante> {
    return this.http.post<Estudiante>(this.apiUrl, estudiante)
  }

  elegirSeleccion(campeon: string, subcampeon: string): Observable<Estudiante> {
    return this.http.get<Estudiante>(this.apiUrl + '/seleccion/' + campeon);
  }
}
