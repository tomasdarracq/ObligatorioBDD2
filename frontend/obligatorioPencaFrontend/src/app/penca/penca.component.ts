import { Component, OnInit } from '@angular/core';
import { PartidoService } from '../core/services/partido.service';
import { Partido } from '../core/models/partido';
import { PrediccionService } from '../core/services/prediccion.service';
import { Prediccion } from '../core/models/prediccion';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { error } from 'console';

@Component({
  selector: 'app-penca',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './penca.component.html',
  styleUrls: ['./penca.component.css']
})
export class PencaComponent implements OnInit {
  fixture: Partido[] = [];
  jugados: Partido[] = []
  prediccionForms: { [key: string]: FormGroup } = {};

  constructor(private fb: FormBuilder, private partidoService: PartidoService, private pencaService: PrediccionService) {}


  ngOnInit() {
    this.getPartidos();
  }


  actualizarFixture() {
    const ahora = new Date();
    this.jugados = this.fixture.filter(partido => new Date(partido.fecha) <= ahora);
    this.fixture = this.fixture.filter(partido => new Date(partido.fecha) > ahora);
  }

  dividirFechas() {
    this.fixture.forEach((partido, index) => {
      const temp = new Date(partido.fecha);
      if (temp.getMinutes() == 0) {
        partido.horario = temp.getHours() + ":" + temp.getMinutes() + "0";
      } else if (temp.getMinutes() > 0 && temp.getMinutes() < 10) {
        partido.horario = temp.getHours() + ":0" + temp.getMinutes();
      } else {
        partido.horario = temp.getHours() + ":" + temp.getMinutes();
      }
      partido.dia = "" + temp.getDate() + "/" + (temp.getMonth() + 1) + "/" + temp.getFullYear();
      partido.id = index;
    });
  }

  crearPrediccion(partidoId: number) {
    const form = this.prediccionForms[partidoId];

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
    //SE REALIZA LA PREDICCION CON ID 1 
    const prediccion = new Prediccion(
      partido.seleccionLocalNombre,
      partido.seleccionVisitanteNombre,
      partido.fecha,
      golLocal,
      golVisitante
    );

    console.log(prediccion);
    this.pencaService.guardarPrediccion(prediccion).subscribe(
      (data: any) => console.log('Predicción guardada:', data),
      error => console.log('Error al guardar la predicción:', error)
    );
  }

  getPartidos() {
    this.partidoService.getAllPartidos().subscribe(
      (partidos: Partido[]) => {
        this.fixture = partidos;
        this.dividirFechas();
        this.ordenarFechas();
        this.actualizarFixture();
        this.crearFormulariosDePrediccion();
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

  crearFormulariosDePrediccion() {
    this.fixture.forEach(partido => {
      this.prediccionForms[partido.id] = this.fb.group({
        golLocal: ['', Validators.required],
        golVisitante: ['', Validators.required]
      });
    });
  }
}
