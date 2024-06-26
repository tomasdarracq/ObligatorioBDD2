import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Seleccion } from '../core/models/seleccion';
import { SeleccionService } from '../core/services/seleccion.service';
import { AdminNavBarComponent } from '../nav-bar/admin-nav-bar/admin-nav-bar.component';

@Component({
  selector: 'app-campeon',
  standalone: true,
  imports: [ReactiveFormsModule, AdminNavBarComponent],
  templateUrl: './campeon.component.html',
  styleUrl: './campeon.component.css'
})
export class CampeonComponent {
  finalistasForm !: FormGroup;
  selecciones: Seleccion[] = [];
  idAdmin!: number;
  guardado: boolean | undefined = undefined;
  campeon: Seleccion | undefined;
  subcampeon: Seleccion | undefined;

  constructor(private fb: FormBuilder, private seleccionService: SeleccionService) { }

  ngOnInit() {
    this.finalistasForm = this.fb.group({
      campeon: ['', Validators.required],
      subcampeon: ['', Validators.required]
    });
    this.seleccionService.obtenerAllSelecciones();
    this.selecciones = this.seleccionService.selecciones;
  }

  resultadoFinalistas() {
    if (this.finalistasForm.valid) {
      const campeon = new Seleccion(
        this.finalistasForm.get('campeon')?.value.trim(),
        'Campeón'
      );

      const subcampeon = new Seleccion(
        this.finalistasForm.get('subcampeon')?.value.trim(),
        'Subcampeón'
      );

      console.log('Campeón:', campeon);
      console.log('Subcampeón:', subcampeon);


      this.seleccionService.actualizarSeleccion(campeon).subscribe(
        (data: any) => {
          console.log('Campeon elegido:', data),
            this.seleccionService.actualizarSeleccion(subcampeon).subscribe(
              (data: any) => {
                console.log('Subcampeón elegido:', data),
                  this.guardado = true;
                  this.recargar();
              },
              error =>
                console.log('Error al guardar la predicción:', error),
            )
        },
        error => {
          console.log('Error al guardar la predicción:', error),
            this.guardado = false
        }
      )
    } else {
      this.finalistasForm.markAllAsTouched();
    }
  }

  esValido(input: string): boolean {
    const control = this.finalistasForm.get(input);
    return !!control?.invalid && control?.touched;
  }

  deshabilitarOpcion(opcion: string, otroControl: string): boolean {
    const eleccion = this.finalistasForm.get(otroControl)?.value;
    return eleccion === opcion;
  }

  habilitarActualizacion(): boolean {
    let actualizable = true;
    this.selecciones.forEach(pais => {
      if (pais.estado != null) {
        actualizable = false;
        if (pais.estado === 'Campeón') {
          this.campeon = pais;
        } else if (pais.estado === 'Subcampeón') {
          this.subcampeon = pais;
        }
      }
    });
    return actualizable;
  }

  recargar() {
    this.esperar(1500).then(() => {
      window.location.reload();
    })
  }

  esperar(ms: number) {
    return new Promise(r => setTimeout(r, ms));
  }
}
