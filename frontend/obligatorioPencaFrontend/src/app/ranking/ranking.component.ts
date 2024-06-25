import { Component } from '@angular/core';
import { EstudianteService } from '../core/services/estudiante.service';
import { Estudiante } from '../core/models/estudiante';
import { EstudianteNavBarComponent } from '../nav-bar/estudiante-nav-bar/estudiante-nav-bar.component';

@Component({
  selector: 'app-ranking',
  standalone: true,
  imports: [EstudianteNavBarComponent],
  templateUrl: './ranking.component.html',
  styleUrl: './ranking.component.css'
})
export class RankingComponent {
  ranking: Estudiante[] = [];
  constructor(private estudianteService: EstudianteService) { }

  ngOnInit() {
    this.getEstudiantes();
    this.ordenarRanking();
  }
  getEstudiantes() {
    this.estudianteService.getAllEstudiantes().subscribe(
      (estudiantes: Estudiante[]) => {
        this.ranking = estudiantes;
        this.ordenarRanking();

      },
      (error) => console.log(error)
    );
  }

  ordenarRanking() {
    this.ranking = this.ranking
      .map(estudiante => ({
        ...estudiante,
        puntajeTotal: estudiante.puntajeTotal ?? 0  // Si puntajeTotal es null se le asigna 0
      }))
      .sort((a, b) => b.puntajeTotal - a.puntajeTotal)
      .map((estudiante, index) => ({ ...estudiante, posicion: index + 1 }));
  }

}
