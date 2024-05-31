import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { Prediccion } from '../models/prediccion';

@Injectable({
  providedIn: 'root'
})
export class PencaService {
  private apiUrl = 'http://localhost:8080/api/prediccion';

  constructor(private http: HttpClient) { }

  guardarPrediccion(prediccion: Prediccion): Observable<Object> {
    return this.http.post<Prediccion>(this.apiUrl, prediccion).pipe(
      catchError((error) => {
        console.error('Error:', error);
        throw error;
      })
    );
  }
}
