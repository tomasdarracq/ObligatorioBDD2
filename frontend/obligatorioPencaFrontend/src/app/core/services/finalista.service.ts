import { Injectable } from '@angular/core';
import { Finalista } from '../models/finalista';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FinalistaService {
  private apiUrl = 'http://localhost:8080/api/prediccionCampeon';

  constructor(private http: HttpClient) { }

  elegirSeleccion(seleccion: Finalista): Observable<Finalista> {
    return this.http.post<Finalista>(this.apiUrl, seleccion);
  }
}
