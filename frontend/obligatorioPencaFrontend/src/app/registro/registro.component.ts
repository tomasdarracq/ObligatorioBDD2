import { Component } from '@angular/core';
import { SeleccionService } from '../core/services/seleccion.service';
import { Seleccion } from '../core/models/seleccion';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Estudiante } from '../core/models/estudiante';
import { EstudianteService } from '../core/services/estudiante.service';

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css'
})
export class RegistroComponent {
  registroForm !: FormGroup;
  selecciones: Seleccion[] = [];

  constructor(private fb: FormBuilder, private seleccionService: SeleccionService, private estudianteService: EstudianteService) { }

  ngOnInit() {
    this.registroForm = this.fb.group({
      nombre: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      contrasena: ['', Validators.required],
      carrera: ['', Validators.required],
      campeon: ['', Validators.required],
      subcampeon: ['', Validators.required]
    });
    this.seleccionService.obtenerAllSelecciones();
    this.selecciones = this.seleccionService.selecciones;
  }

  crearUsuario() {
    if (this.registroForm.valid) {
      const estudiante = new Estudiante(
        0,
        this.registroForm.get('nombre')?.value.trim(),
        this.registroForm.get('email')?.value.trim(),
        this.registroForm.get('contrasena')?.value,
        this.registroForm.get('carrera')?.value.trim(),
        0
      )
      console.log('New User:', estudiante);
      console.log(this.registroForm.get('campeon')?.value);
      console.log(this.registroForm.get('subcampeon')?.value);
      this.estudianteService.crearEstudiante(estudiante);
      this.estudianteService.elegirSeleccion(this.registroForm.get('campeon')?.value, this.registroForm.get('subcampeon')?.value);
    } else {
      this.registroForm.markAllAsTouched();
    }
  }

  esValido(input: string): boolean {
    const control = this.registroForm.get(input);
    return !!control?.invalid && control?.touched;
  }

  desabilitarOpcion(opcion: string, otroControl: string): boolean {
    const eleccion = this.registroForm.get(otroControl)?.value;
    return eleccion === opcion;
  }
}
