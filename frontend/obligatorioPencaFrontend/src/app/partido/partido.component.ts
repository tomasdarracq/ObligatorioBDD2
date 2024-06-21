import { Component } from '@angular/core';
import { Partido } from '../core/models/partido';
import { PartidoService } from '../core/services/partido.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Seleccion } from '../core/models/seleccion';
import { SeleccionService } from '../core/services/seleccion.service';

@Component({
  selector: 'app-partido',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './partido.component.html',
  styleUrl: './partido.component.css'
})
export class PartidoComponent {
  fixture: Partido[] = [];
  jugados: Partido[] = [];
  selecciones: Seleccion[] = [];
  resultadoForms: { [key: string]: FormGroup } = {};
  crearPartidoForm!: FormGroup;
  mostrarForm: boolean = false;
  mensajeModal: string = '';

  constructor(private fb: FormBuilder, private partidoService: PartidoService, private seleccionService: SeleccionService) { }

  ngOnInit() {
    this.partidoService.obtenerPartidos();
    this.fixture = this.partidoService.fixture;
    this.jugados = this.partidoService.jugados;

    this.crearFormulariosResultado();
    this.crearFormularioPartido();

    this.seleccionService.obtenerAllSelecciones();
    this.selecciones = this.seleccionService.selecciones;
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

    const partido = this.jugados.find(p => p.id === partidoId);

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

  crearFormulariosResultado() {
    this.jugados.forEach(jugado => {
      this.resultadoForms[jugado.id] = this.fb.group({
        golLocal: ['', Validators.required],
        golVisitante: ['', Validators.required]
      });
    });
  }

  crearFormularioPartido() {
    this.crearPartidoForm = this.fb.group({
      seleccionLocalNombre: ['', Validators.required],
      seleccionVisitanteNombre: ['', Validators.required],
      fecha: ['', Validators.required],
    });
  }

  crearPartido() {
    const nuevoPartido = this.crearPartidoForm.value;
    this.partidoService.crearPartido(nuevoPartido).subscribe(
      (data: any) => {
        console.log('Predicción guardada:', data),
          this.mensajeModal = 'Partido creado con exito',
          this.partidoService.obtenerPartidos();
          this.mostrarFormulario();
      },
      error => {
        console.log('Error al guardar la predicción:', error),
          this.mensajeModal = 'Error al crear el partido';
      }
    )
    console.log(nuevoPartido);
  }

  deshabilitarOpcion(opcion: string, otroControl: string): boolean {
    const eleccion = this.crearPartidoForm.get(otroControl)?.value;
    return eleccion === opcion;
  }

  mostrarFormulario() {
    this.mostrarForm = !this.mostrarForm;
    this.crearPartidoForm.reset({
      fecha: null,
      seleccionLocalNombre: '',
      seleccionVisitanteNombre: ''
    });
  }

}
