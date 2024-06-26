import { Component } from '@angular/core';
import { SeleccionService } from '../core/services/seleccion.service';
import { Seleccion } from '../core/models/seleccion';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Estudiante } from '../core/models/estudiante';
import { EstudianteService } from '../core/services/estudiante.service';
import { Finalista } from '../core/models/finalista';
import { FinalistaService } from '../core/services/finalista.service';
import { Router } from '@angular/router';

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
  idEstudiante!: number;
  mensajeModal: string = '';
  carreras !: string[];
  constructor(private fb: FormBuilder, private seleccionService: SeleccionService, private estudianteService: EstudianteService, private finalistaService: FinalistaService, private router: Router) { }

  ngOnInit() {
    this.carreras = this.estudianteService.carreras;
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
      );

      console.log('Nuevo Usuario:', estudiante);
      console.log(this.registroForm.get('campeon')?.value);
      console.log(this.registroForm.get('subcampeon')?.value);

      this.estudianteService.crearEstudiante(estudiante).subscribe(
        (id: number) => {
          console.log('Estudiante creado con ID:', id);
          const campeon = new Finalista(id, this.registroForm.get('campeon')?.value, 'Campeon');
          const subcampeon = new Finalista(id, this.registroForm.get('subcampeon')?.value, 'Subcampeon');

          this.finalistaService.elegirSeleccion(campeon).subscribe(
            (data: any) => console.log('Campeon elegido:', data),
            error => {
              console.log('Error al guardar la predicción:', error),
              this.mensajeModal = 'ERROR AL CREAR LA CUENTA'
            }
          )

          this.finalistaService.elegirSeleccion(subcampeon).subscribe(
            (data: any) => console.log('Subcampeón elegido:', data),
            error => {
              console.log('Error al guardar la predicción:', error),
              this.mensajeModal = 'ERROR AL CREAR LA CUENTA'
            }
          )
          this.mensajeModal = 'CUENTA CREADA CON ÉXITO';
        },
        (error) => {
          console.error('Error al crear el estudiante:', error);
          this.mensajeModal = 'ERROR AL CREAR LA CUENTA';
        });
    } else {
      this.registroForm.markAllAsTouched();
      this.mensajeModal = 'ERROR AL CREAR LA CUENTA';
    }
  }

  esValido(input: string): boolean {
    const control = this.registroForm.get(input);
    return !!control?.invalid && control?.touched;
  }

  deshabilitarOpcion(opcion: string, otroControl: string): boolean {
    const eleccion = this.registroForm.get(otroControl)?.value;
    return eleccion === opcion;
  }

  redirectToLogin() {
    this.router.navigate(['']);
  }

}
