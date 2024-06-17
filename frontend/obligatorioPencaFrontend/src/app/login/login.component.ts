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
          console.log('Inicio de Sesión Exitoso', response);
          const idUsuario = response;
          //this.router.navigate(['/fixture', userId]);
          this.router.navigateByUrl(idUsuario + '/fixture'); // Cambiar '/fixture' por la ruta deseada
        },
        error => {
          console.error('Inicio de Sesión Fallido:', error);
        }
      );
    }
  }
}
