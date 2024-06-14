import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Partido } from '../models/partido';
import { Observable, catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PartidoService {
  private apiUrl = 'http://localhost:8080/api/partido';

  fixture: Partido[] = [];
  jugados: Partido[] = [];

  constructor(private http: HttpClient) { }

  getAllPartidos(): Observable<Partido[]> {
    return this.http.get<Partido[]>(this.apiUrl).pipe(
      catchError((error) => {
        console.error('Error:', error);
        throw error;
      })
    );
};

  actualizarPartido(partido: Partido): Observable<Partido> {
    return this.http.put<Partido>(this.apiUrl, partido);
  }
  
  obtenerPartidos() {
    this.getAllPartidos().subscribe(
      (partidos: Partido[]) => {
        this.fixture = partidos;
        this.dividirFechas();
        this.ordenarFechas();
        this.actualizarFixture();
        this.ordenarJugados();
      },
      (error) => console.log(error)
    );
  }

  dividirFechas() {
    this.fixture.forEach((partido, index) => {
      const temp = new Date(partido.fecha);
      if (temp.getMinutes() == 0) {
        partido.horario = temp.getHours() + ":" + temp.getMinutes() + "0";
      } else if (temp.getMinutes() > 0 && temp.getMinutes() < 10) {
        partido.horario = temp.getHours() + ":0" + temp.getMinutes();
      } else {
        partido.horario = temp.getHours() + ":" + temp.getMinutes();
      }
      partido.dia = "" + temp.getDate() + "/" + (temp.getMonth() + 1) + "/" + temp.getFullYear();
      partido.id = index;
    });
  }
  ordenarFechas() {
    this.fixture.sort((a, b) => {
      return new Date(a.fecha).getTime() - new Date(b.fecha).getTime();
    });
  }

  actualizarFixture() {
    const ahora = new Date();
    this.jugados = this.fixture.filter(partido => new Date(partido.fecha) <= ahora);
    this.fixture = this.fixture.filter(partido => new Date(partido.fecha) > ahora);
  }

  ordenarJugados() {
    this.jugados.sort((a, b) => {
      return new Date(b.fecha).getTime() - new Date(a.fecha).getTime();
    });
  }
}
