import { Component, OnInit } from '@angular/core';
import { PartidoService } from '../core/services/partido.service';
import { Partido } from '../core/models/partido';
import { PrediccionService } from '../core/services/prediccion.service';
import { Prediccion } from '../core/models/prediccion';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { EstudianteNavBarComponent } from '../nav-bar/estudiante-nav-bar/estudiante-nav-bar.component';

@Component({
  selector: 'app-penca',
  standalone: true,
  imports: [ReactiveFormsModule, EstudianteNavBarComponent],
  templateUrl: './penca.component.html',
  styleUrls: ['./penca.component.css']
})
export class PencaComponent implements OnInit {
  fixture: Partido[] = [];
  jugados: Partido[] = [];
  predicciones: Prediccion[] = [];
  nuevaPrediccionForms: { [key: string]: FormGroup } = {};
  actualizarPrediccionForms: { [key: string]: FormGroup } = {};
  idEstudiante: number = -1;

  constructor(private fb: FormBuilder, private partidoService: PartidoService, private prediccionService: PrediccionService, private activatedRoute: ActivatedRoute) { }


  ngOnInit() {
    this.idEstudiante = Number(this.activatedRoute.snapshot.paramMap.get('idEstudiante'));

    this.partidoService.obtenerPartidos();
    this.fixture = this.partidoService.fixture;
    this.jugados = this.partidoService.jugados;

    this.obtenerPredicciones();
  }

  puedePredecir(fechaPartido: Date): boolean {
    if (!(fechaPartido instanceof Date)) {
      fechaPartido = new Date(fechaPartido);
    }

    const ahora = new Date();
    const horaAntesPartido = new Date(fechaPartido.getTime() - 60 * 60 * 1000);
    return ahora <= horaAntesPartido;
  }

  crearPrediccion(partidoId: number) {
    const form = this.nuevaPrediccionForms[partidoId];

    if (form.invalid) {
      console.log("Formulario inválido. No se puede crear la predicción.");
      return;
    }

    const golLocal = form.get('golLocal')?.value;
    const golVisitante = form.get('golVisitante')?.value;

    if (golLocal === null || golLocal === undefined || golVisitante === null || golVisitante === undefined) {
      console.log("Error: Valores inválidos para goles.");
      return;
    }

    const partido = this.fixture.find(p => p.id === partidoId);

    if (!partido) {
      console.log("Partido no encontrado.");
      return;
    }

    console.log(this.idEstudiante)
    const prediccion = new Prediccion(
      this.idEstudiante,
      partido.seleccionLocalNombre,
      partido.seleccionVisitanteNombre,
      partido.fecha,
      golLocal,
      golVisitante,
      0
    );

    console.log(prediccion);
    this.prediccionService.guardarPrediccion(prediccion).subscribe(
      (data: any) => {
        console.log('Predicción guardada: ', data),
          this.obtenerPredicciones();
      },
      error => console.log('Error al guardar la predicción:', error)
    );
  }

  crearFormulariosDePrediccion() {
    this.predicciones.forEach(prediccion => {
      this.actualizarPrediccionForms[prediccion.id] = this.fb.group({
        golLocal: ['', Validators.required],
        golVisitante: ['', Validators.required]
      });
    });
    this.fixture.forEach(partido => {
      this.nuevaPrediccionForms[partido.id] = this.fb.group({
        golLocal: ['', Validators.required],
        golVisitante: ['', Validators.required]
      });
    });
  }

  obtenerPredicciones() {
    this.prediccionService.getAllPrediccionesById(this.idEstudiante).subscribe(
      (prediccion: Prediccion[]) => {
        this.predicciones = prediccion;
        this.dividirFechasPrediccion();
        this.ordenarPredicciones();
        this.filtrarPredicciones();
        this.crearFormulariosDePrediccion();

      },
      (error) => console.log(error)
    );
  }

  dividirFechasPrediccion() {
    this.predicciones.forEach((prediccion, index) => {
      const temp = new Date(prediccion.fechaPartido);
      if (temp.getMinutes() == 0) {
        prediccion.horario = temp.getHours() + ":" + temp.getMinutes() + "0";
      } else if (temp.getMinutes() > 0 && temp.getMinutes() < 10) {
        prediccion.horario = temp.getHours() + ":0" + temp.getMinutes();
      } else {
        prediccion.horario = temp.getHours() + ":" + temp.getMinutes();
      }
      prediccion.dia = "" + temp.getDate() + "/" + (temp.getMonth() + 1) + "/" + temp.getFullYear();
      prediccion.id = index;
    });
  }

  ordenarPredicciones() {
    this.predicciones.sort((a, b) => {
      return new Date(a.fechaPartido).getTime() - new Date(b.fechaPartido).getTime();
    });
  }

  filtrarPredicciones() {
    this.predicciones.forEach(p => {
      this.jugados.forEach(j => {
        if (p.fechaPartido == j.fecha && p.nombreSeleccionLocal == j.seleccionLocalNombre && p.nombreSeleccionVisitante == j.seleccionVisitanteNombre) {
          p.jugado = true;
          j.prediccionGolesLocal = p.golLocal;
          j.prediccionGolesVisitante = p.golVisitante;
          j.prediccionPuntaje = p.puntaje;
        }
      });
      this.fixture.forEach(f => {
        if (p.fechaPartido == f.fecha && p.nombreSeleccionLocal == f.seleccionLocalNombre && p.nombreSeleccionVisitante == f.seleccionVisitanteNombre) {
          f.predicho = true;
          f.prediccionGolesLocal = p.golLocal;
          f.prediccionGolesVisitante = p.golVisitante;
        }
      })
    });
  }

  actualizarPrediccion(prediccionId: number) {
    const form = this.actualizarPrediccionForms[prediccionId];

    if (form.invalid) {
      console.log("Formulario inválido. No se puede crear la predicción.");
      return;
    }

    const golLocal = form.get('golLocal')?.value;
    const golVisitante = form.get('golVisitante')?.value;

    if (golLocal === null || golLocal === undefined || golVisitante === null || golVisitante === undefined) {
      console.log("Error: Valores inválidos para goles.");
      return;
    }

    const partido = this.predicciones.find(p => p.id === prediccionId);

    if (!partido) {
      console.log("Partido no encontrado.");
      return;
    }
    const prediccion = new Prediccion(
      this.idEstudiante,
      partido.nombreSeleccionLocal,
      partido.nombreSeleccionVisitante,
      partido.fechaPartido,
      golLocal,
      golVisitante,
      0
    );

    console.log(prediccion);
    this.prediccionService.actualizarPrediccion(prediccion).subscribe(
      (data: any) => {
        console.log('Predicción actualizada:', data),
          this.obtenerPredicciones();
      },
      error => console.log('Error al actualizar la predicción:', error)
    );
  }
}
