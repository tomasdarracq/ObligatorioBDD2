import { Component } from '@angular/core';
import { EstudianteService } from '../core/services/estudiante.service';
import { Estudiante } from '../core/models/estudiante';

@Component({
  selector: 'app-ranking',
  standalone: true,
  imports: [],
  templateUrl: './ranking.component.html',
  styleUrl: './ranking.component.css'
})
export class RankingComponent {
  ranking: Estudiante[] = [{
    idEstudiante: 1,
    nombre: "Juan Pérez",
    email: "juan.perez@example.com",
    contrasena: "securePassword123",
    carrera: "Ingeniería Informática",
    puntajeTotal: 89,
  },
  {
    idEstudiante: 2,
    nombre: "María López",
    email: "maria.lopez@example.com",
    contrasena: "myPassword456",
    carrera: "Medicina",
    puntajeTotal: 95,
  },
  {
    idEstudiante: 3,
    nombre: "Carlos Rodríguez",
    email: "carlos.rodriguez@example.com",
    contrasena: "password789",
    carrera: "Derecho",
    puntajeTotal: 78
  },
  {
    idEstudiante: 4,
    nombre: "Ana Gómez",
    email: "ana.gomez@example.com",
    contrasena: "anaPassword321",
    carrera: "Arquitectura",
    puntajeTotal: 82
  },
  {
    idEstudiante: 5,
    nombre: "Luis Fernández",
    email: "luis.fernandez@example.com",
    contrasena: "luisPass654",
    carrera: "Economía",
    puntajeTotal: 88
  }];
  constructor(private estudianteService: EstudianteService) { }

  ngOnInit() {
    //this.getEstudiantes();
    this.ordenarRanking();
  }
  /*getEstudiantes() {
    this.estudianteService.getAllEstudiantes().subscribe(
      (estudiantes: Estudiante[]) => {
        this.ranking = estudiantes;
        this.ordenarRanking();
        
      },
      (error) => console.log(error)
    );
  }*/

  ordenarRanking() {
    this.ranking = this.ranking
      .sort((a, b) => b.puntajeTotal - a.puntajeTotal)
      .map((estudiante, index) => ({ ...estudiante, posicion: index + 1 }));
  }

}
