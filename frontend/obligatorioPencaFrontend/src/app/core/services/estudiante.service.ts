import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Estudiante } from '../models/estudiante';
import { Observable } from 'rxjs';
import { Finalista } from '../models/finalista';

@Injectable({
  providedIn: 'root'
})
export class EstudianteService {

  private apiUrl = 'http://localhost:8080/api/estudiante';

  constructor(private http: HttpClient) { }
  
  getAllEstudiantes(): Observable<Estudiante[]> {
    return this.http.get<Estudiante[]>(this.apiUrl);
  }

  crearEstudiante(estudiante: Estudiante): Observable<number> {
    return this.http.post<number>(this.apiUrl, estudiante)
  }

}
