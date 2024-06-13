import { Component } from '@angular/core';
import { SeleccionService } from '../core/services/seleccion.service';
import { Seleccion } from '../core/models/seleccion';

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [],
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css'
})
export class RegistroComponent {
  
  constructor(private seleccionService: SeleccionService) {
    
  }
  selecciones : Seleccion[] = [];

  ngOnInit() {
    this.obtenerAllSelecciones();
  }

  obtenerAllSelecciones() {
    this.seleccionService.getAllSelecciones().subscribe(
      (equipos: Seleccion[]) => {
        this.selecciones = equipos; 
        console.log(this.selecciones);
      },
      (error) => console.log(error)
    );
  }
}
