import { Component, OnInit } from '@angular/core';
import { PartidoService } from '../core/services/partido.service';
import { Partido } from '../core/models/partido';
import { PencaService } from '../core/services/penca.service';
import { Prediccion } from '../core/models/prediccion';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
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
  prediccion: FormGroup;
  constructor(private partidoService: PartidoService, private pencaService: PencaService) {

    this.prediccion = new FormGroup({
      golLocal: new FormControl('', [Validators.required]),
      golVisitante: new FormControl('', [Validators.required])
    });
  }

  ngOnInit() {
    this.getPartidos();
  }


  actualizarFixture() {
    const ahora = new Date();
    this.jugados = this.fixture.filter(partido => new Date(partido.fecha) <= ahora);
    this.fixture = this.fixture.filter(partido => new Date(partido.fecha) > ahora);
  }

  asignarDia() {
    this.fixture.forEach(partido => {
      const temp = new Date(partido.fecha);
      partido.dia = "" + temp.getDate() + "/" + (temp.getMonth() + 1) + "/" + temp.getFullYear();
    });
  }

  asignarHorario() {
    this.fixture.forEach(partido => {
      const temp = new Date(partido.fecha);
      if (temp.getMinutes() == 0) {
        partido.horario = temp.getHours() + ":" + temp.getMinutes() + "0";
      } else if (temp.getMinutes() > 0 && temp.getMinutes() < 10) {
        partido.horario = temp.getHours() + ":0" + temp.getMinutes();
      } else {
        partido.horario = temp.getHours() + ":" + temp.getMinutes();
      }
    });
  }

  crearPrediccion(partido: Partido) {
    if (this.prediccion.invalid) {
      console.log("Error al crear la prediccion");
      return;
    }

    //SE REALIZA LA PREDICCION CON ID 1 
    const prediccion = new Prediccion(
      partido.seleccionLocalNombre,
      partido.seleccionVisitanteNombre,
      partido.fecha,
      this.prediccion.value.golLocal,
      this.prediccion.value.golVisitante
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
        this.asignarDia();
        this.asignarHorario();
        this.ordenarFechas();
        this.actualizarFixture();
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

}
