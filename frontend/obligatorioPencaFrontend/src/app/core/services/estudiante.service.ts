import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Estudiante } from '../models/estudiante';
import { Observable } from 'rxjs';
import { Finalista } from '../models/finalista';

@Injectable({
  providedIn: 'root'
})
export class EstudianteService {

  private apiUrl = 'http://localhost:8080/api/estudiante';
  carreras: string[] = [
    'Abogacía',
    'Acompañamiento Terapéutico',
    'Agronomía',
    'Analista en Informática',
    'Arquitectura',
    'Artes Escénicas',
    'Artes Visuales',
    'Business Analytics',
    'Ciencia Política',
    'Cine',
    'Comunicación',
    'Comunicación y Marketing',
    'Contador Público',
    'Datos y Negocios',
    'Desarrollador de Software',
    'Dirección de Empresas',
    'Economía',
    'Educación Inicial',
    'Finanzas',
    'Fisioterapia',
    'Fonoaudiología',
    'Gestión Humana',
    'Ingeniería Ambiental',
    'Ingeniería en Alimentos',
    'Ingeniería en Electrónica',
    'Ingeniería en Informática',
    'Ingeniería Industrial',
    'Inteligencia Artificial y Ciencia de Datos',
    'Licenciatura en Enfermería',
    'Licenciatura en Enfermería (Profesionalización)',
    'Licenciatura en Informática',
    'Medicina',
    'Negocios Internacionales',
    'Negocios y Economía',
    'Notariado',
    'Nutrición',
    'Odontología',
    'Psicología',
    'Psicomotricidad',
    'Psicopedagogía',
    'Recreación Educativa',
    'Sociología',
    'Trabajo Social'
]

  constructor(private http: HttpClient) { }
  
  getAllEstudiantes(): Observable<Estudiante[]> {
    return this.http.get<Estudiante[]>(this.apiUrl);
  }

  crearEstudiante(estudiante: Estudiante): Observable<number> {
    return this.http.post<number>(this.apiUrl, estudiante)
  }

}
