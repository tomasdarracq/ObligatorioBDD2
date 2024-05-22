import { Component } from '@angular/core';
import { PartidoService } from './partido.service';
import { Partido } from './partido';

@Component({
  selector: 'app-penca',
  standalone: true,
  imports: [],
  templateUrl: './penca.component.html',
  styleUrl: './penca.component.css'
})
export class PencaComponent {
  fixture: Partido[] = [];
  constructor(private partidoService: PartidoService) { }
  ngOnInit() {
    this.getPartidos();
  }
  

  getPartidos() {
    this.partidoService.getAllPartidos().subscribe((partidos) =>
      (partidos: Partido[]) => {
        this.fixture = partidos;
      },
      (error) => console.log(error)
    );
  }
  /*fixture = [
    {
      fecha: '2023-05-17',
      partidos: [
        { id: 1, local: 'Uruguay', visitante: 'Brasil' },
        { id: 2, local: 'Ecuador', visitante: 'Paraguay' }
      ]
    },
    {
      fecha: '2023-05-18',
      partidos: [
        { id: 3, local: 'Venezuela', visitante: 'México' },
        { id: 4, local: 'EEUU', visitante: 'Colombia' }
      ]
    },
    {
      fecha: '2023-05-17',
      partidos: [
        { id: 1, local: 'Uruguay', visitante: 'Brasil' },
        { id: 2, local: 'Ecuador', visitante: 'Paraguay' }
      ]
    },
    {
      fecha: '2023-05-18',
      partidos: [
        { id: 3, local: 'Venezuela', visitante: 'México' },
        { id: 4, local: 'EEUU', visitante: 'Colombia' }
      ]
    },
    {
      fecha: '2023-05-17',
      partidos: [
        { id: 1, local: 'Uruguay', visitante: 'Brasil' },
        { id: 2, local: 'Ecuador', visitante: 'Paraguay' }
      ]
    },
    {
      fecha: '2023-05-18',
      partidos: [
        { id: 3, local: 'Venezuela', visitante: 'México' },
        { id: 4, local: 'EEUU', visitante: 'Colombia' }
      ]
    }
  ];*/
}
