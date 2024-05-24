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
        this.orderByDate();
        this.updateFixture();
      },
      (error) => console.log(error)
    );
  }

  orderByDate() {
    this.fixture.sort((a, b) => {
      //Ordenar por dia
      return new Date(a.fecha).getTime() - new Date(b.fecha).getTime();
      //chequear hora

    });
  }

  updateFixture() {
    //Si la fecha del partido ya ha pasado, agregarlo a jugados, y eliminarlo de fixture
    this.fixture.forEach(partido => {
      if (new Date(partido.fecha) <= new Date()) {
        this.jugados.push(partido);
        this.fixture.splice(this.fixture.indexOf(partido), 1);
      }
    })
  }
}
