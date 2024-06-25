import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-estudiante-nav-bar',
  standalone: true,
  imports: [],
  templateUrl: './estudiante-nav-bar.component.html',
  styleUrl: './estudiante-nav-bar.component.css'
})
export class EstudianteNavBarComponent {
  idEstudiante!: number;

  constructor(private router: Router, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.idEstudiante = Number(this.activatedRoute.snapshot.paramMap.get('idEstudiante'));
  }

  logout() {
    this.router.navigate(['']);
  }

}
