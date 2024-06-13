import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Seleccion } from '../models/seleccion';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SeleccionService {
  private apiUrl = 'http://localhost:8080/api/seleccion';


  constructor(private http: HttpClient) { }

  getAllSelecciones(): Observable<Seleccion[]> {
    return this.http.get<Seleccion[]>(this.apiUrl);
  }
}
