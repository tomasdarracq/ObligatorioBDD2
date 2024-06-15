import { Component } from '@angular/core';
import { Partido } from '../core/models/partido';
import { PartidoService } from '../core/services/partido.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-partido',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './partido.component.html',
  styleUrl: './partido.component.css'
})
export class PartidoComponent {
  fixture: Partido[] = [];
  jugados: Partido[] = []
  resultadoForms: { [key: string]: FormGroup } = {};
  constructor(private fb: FormBuilder, private partidoService: PartidoService) { }

  ngOnInit() {
    this.partidoService.obtenerPartidos();
    this.fixture = this.partidoService.fixture;
    this.jugados = this.partidoService.jugados;
    this.crearFormulariosDeResultado();
  }

  ingresarResultado(partidoId: number) {
    const form = this.resultadoForms[partidoId];

    if (form.invalid) {
      console.log("Formulario inválido. No se puede actualizar el resultado.");
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
    const resultado = new Partido(
      partido.seleccionLocalNombre,
      partido.seleccionVisitanteNombre,
      partido.fecha,
      golLocal,
      golVisitante
    );

    console.log(resultado);
    this.partidoService.actualizarPartido(resultado).subscribe(
      (data: any) => console.log('Predicción guardada:', data),
      error => console.log('Error al guardar la predicción:', error)
    );
  }

  crearFormulariosDeResultado() {
    this.jugados.forEach(jugado => {
      this.resultadoForms[jugado.id] = this.fb.group({
        golLocal: ['', Validators.required],
        golVisitante: ['', Validators.required]
      });
    });
  }
}
