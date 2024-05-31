import { Component, OnInit } from '@angular/core';
import { PartidoService } from '../core/services/partido.service';
import { Partido } from '../core/models/partido';

@Component({
  selector: 'app-penca',
  standalone: true,
  imports: [],
  templateUrl: './penca.component.html',
  styleUrls: ['./penca.component.css']
})
export class PencaComponent implements OnInit {
  fixture: Partido[] = [];
  jugados: Partido[] = []
  constructor(private partidoService: PartidoService) { }

  ngOnInit() {
    this.getPartidos();
  }

  getPartidos() {
    this.partidoService.getAllPartidos().subscribe(
      (partidos: Partido[]) => {
        this.fixture = partidos;
        this.asignarDia();
        this.asignarHorario();
        this.ordenarFechas();
        this.actualizarFixture();
      },
      (error) => console.log(error)
    );
  }

  asignarHorario() {
    this.fixture.forEach(partido => {
      const temp = new Date(partido.fecha);
      if (temp.getMinutes() == 0) {
        partido.horario = temp.getHours() + ":" + temp.getMinutes() + "0";
      } else if (temp.getMinutes() > 0 && temp.getMinutes() < 10) {
        partido.horario = temp.getHours() + ":0" + temp.getMinutes();
      } else {
        partido.horario = temp.getHours() + ":" + temp.getMinutes();
      }
    });
  }

  asignarDia() {
    this.fixture.forEach(partido => {
      const temp = new Date(partido.fecha);
      partido.dia = "" + temp.getDate() + "/" + (temp.getMonth() + 1) + "/" + temp.getFullYear();
    });
  }

  ordenarFechas() {
    this.fixture.sort((a, b) => {
      //Ordenar por dia
      return new Date(a.fecha).getTime() - new Date(b.fecha).getTime();
    });
  }

  actualizarFixture() {
    const now = new Date();
    this.jugados = this.fixture.filter(partido => new Date(partido.fecha) <= now);
    this.fixture = this.fixture.filter(partido => new Date(partido.fecha) > now);
  }
}
