import { Component } from '@angular/core';
import { Partido } from '../core/models/partido';
import { PartidoService } from '../core/services/partido.service';
import { Time } from '@angular/common';

@Component({
  selector: 'app-partido',
  standalone: true,
  imports: [],
  templateUrl: './partido.component.html',
  styleUrl: './partido.component.css'
})
export class PartidoComponent {
  fixture: Partido[] = [];
  jugados: Partido[] = []
  constructor(private partidoService: PartidoService) { }

  ngOnInit() {
    this.getPartidos();
  }



  actualizarFixture() {
    const ahora = new Date();
    this.jugados = this.fixture.filter(partido => new Date(partido.fecha) <= ahora);
    this.fixture = this.fixture.filter(partido => new Date(partido.fecha) > ahora);
  }

    asignarDia() {
    this.fixture.forEach(partido => {
      const temp = new Date(partido.fecha);
      partido.dia = "" + temp.getDate() + "/" + (temp.getMonth() + 1) + "/" + temp.getFullYear();
    });
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

  ordenarFechas() {
    this.fixture.sort((a, b) => {
      //Ordenar por dia
      return new Date(a.fecha).getTime() - new Date(b.fecha).getTime();
    });
  }

}
