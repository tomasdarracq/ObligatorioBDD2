import { Component } from '@angular/core';

@Component({
  selector: 'app-penca',
  standalone: true,
  imports: [],
  templateUrl: './penca.component.html',
  styleUrl: './penca.component.css'
})
export class PencaComponent {
  fixture = [
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
  ];
}
