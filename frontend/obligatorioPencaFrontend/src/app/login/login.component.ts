import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { login } from '../core/models/login';
import { PartidoService } from '../core/services/partido.service';
import { loginService } from '../core/services/login.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  respuesta = ""
  fail: boolean = false;

  constructor(private fb: FormBuilder, private router: Router, private estudianteService: loginService, private partidoService: PartidoService) { }
  ngOnInit() {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      contrasena: ['', Validators.required],
    });

  }

  iniciarSesion() {
    if (this.loginForm.valid) {
      const { email, contrasena } = this.loginForm.value; // Desestructura los valores del formulario
      const loginData = new login(email, contrasena); // Crea una instancia de la clase Login con los datos del formulario

      this.estudianteService.iniciarsesion(loginData).subscribe(
        response => {
          if (response != null) {
            console.log('Inicio de Sesión Exitoso', response);
            this.fail = false;
            const idUsuario = response;
            if (idUsuario == 0) {
              this.router.navigateByUrl(idUsuario + '/fixture/update');
              this.partidoService.obtenerPartidos();
            }
            else {
              this.router.navigateByUrl(idUsuario + '/fixture');
              this.partidoService.obtenerPartidos();
            }
          }
          else {
            console.log(response)
            this.fail = true;
          }

        },
        error => {
          console.error('Inicio de Sesión Fallido:', error);
        }
      );
    }
  }

  esValido(input: string): boolean {
    const control = this.loginForm.get(input);
    return !!control?.invalid && control?.touched;
  }
}
