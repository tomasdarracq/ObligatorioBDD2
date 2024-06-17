import { Observable,catchError } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { login } from '../models/login';

@Injectable({
  providedIn: 'root'
})
export class loginService {

  private apiUrl = 'http://localhost:8080/login';

  constructor(private http: HttpClient) { }
  
  iniciarsesion(login: login) : Observable<any>{
    return this.http.post<any>(this.apiUrl, login).pipe(
        catchError((error) => {
          console.error('Error:', error);
          throw error;
        })
      );
  }
  
}