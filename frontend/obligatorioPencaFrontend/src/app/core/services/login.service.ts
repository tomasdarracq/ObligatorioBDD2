import { Observable,catchError } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { login } from '../models/login';

@Injectable({
  providedIn: 'root'
})
export class loginService {

  private apiUrl = 'http://localhost:8080/api/estudiante/iniciarsesion';

  constructor(private http: HttpClient) { }
  
  iniciarsesion(login: login) : Observable<login>{
    return this.http.post<login>(this.apiUrl, login).pipe(
        catchError((error) => {
          console.error('Error:', error);
          throw error;
        })
      );
  }
  
}