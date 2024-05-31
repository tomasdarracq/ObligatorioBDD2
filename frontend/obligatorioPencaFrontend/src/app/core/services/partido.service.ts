import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Partido } from '../models/partido';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PartidoService {
  private apiUrl = 'http://localhost:8080/api/partido';

  constructor(private http: HttpClient) { }
  
  getAllPartidos(): Observable<Partido[]> {
    return this.http.get<Partido[]>(this.apiUrl);
  }
}
