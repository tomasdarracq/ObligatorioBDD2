import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { Prediccion } from '../models/prediccion';

@Injectable({
  providedIn: 'root'
})
export class PrediccionService {
  private apiUrl = 'http://localhost:8080/api/prediccion';

  constructor(private http: HttpClient) { }

  getAllPrediccionesById(idEstudiante: number): Observable<Prediccion[]> {
    return this.http.get<Prediccion[]>(`${this.apiUrl}/estudiante/${idEstudiante}`);
  }

  guardarPrediccion(prediccion: Prediccion): Observable<Object> {
    return this.http.post<Prediccion>(this.apiUrl, prediccion).pipe(
      catchError((error) => {
        console.error('Error:', error);
        throw error;
      })
    );
  }

  actualizarPrediccion(prediccion: Prediccion): Observable<Object> {
    return this.http.put<Prediccion>(this.apiUrl, prediccion).pipe(
      catchError((error) => {
        console.error('Error:', error);
        throw error;
      })
    );
  }
}
