import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { login } from '../core/models/login';
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

  constructor(private fb: FormBuilder ,private router: Router, private estudianteService: loginService) {}
  ngOnInit() {
    this.loginForm = this.fb.group({
      email: '',
      contrasena: ''
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      const { email, contrasena } = this.loginForm.value; // Desestructura los valores del formulario
      const loginData = new login(email, contrasena); // Crea una instancia de la clase Login con los datos del formulario

      this.estudianteService.iniciarsesion(loginData).subscribe(
        response => {
          console.log('Login successful:', response);
          const userId=response;
          this.router.navigate(['/fixture', userId]);
          //this.router.navigateByUrl('/fixture'); // Cambia '/fixture' por la ruta deseada
        },
        error => {
          console.error('Login failed:', error);
        }
      );
    }
  }
}
