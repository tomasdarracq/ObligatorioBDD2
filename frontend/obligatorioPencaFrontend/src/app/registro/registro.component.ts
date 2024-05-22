import { Component } from '@angular/core';

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [],
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css'
})
export class RegistroComponent {
  
  selecciones = [
    { nombre: 'Argentina' },
    { nombre: 'Bolivia' },
    { nombre: 'Brasil' },
    { nombre: 'Canadá' },
    { nombre: 'Chile' },
    { nombre: 'Colombia' },
    { nombre: 'Costa Rica' },
    { nombre: 'Ecuador' },
    { nombre: 'Estados Unidos' },
    { nombre: 'Jamaica' },
    { nombre: 'México' },
    { nombre: 'Panamá' },
    { nombre: 'Paraguay' },
    { nombre: 'Perú' },
    { nombre: 'Uruguay' },
    { nombre: 'Venezuela' }
  ];
}
