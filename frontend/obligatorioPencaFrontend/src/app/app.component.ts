import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavigationEnd, RouterOutlet, Router, ActivatedRoute } from '@angular/router';
import { filter, map, mergeMap } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'obligatorioPencaFrontend';
  mostrarNavBar = false;
  idEstudiante!: number;

  constructor(private router: Router, private activatedRoute: ActivatedRoute) {// Handle showing/hiding nav bar based on route data
    //Mostrar/Esconder NavBar
  
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd),
      map(() => this.activatedRoute),
      map(route => {
        while (route.firstChild) {
          route = route.firstChild;
        }
        return route;
      }),
      mergeMap(route => route.data)
    ).subscribe(data => {
      this.mostrarNavBar = !data['esconderNavBar'];
    });

    // Obtener IdEstudiante
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd),
      map(() => this.activatedRoute),
      map(route => {
        while (route.firstChild) {
          route = route.firstChild;
        }
        return route;
      }),
      mergeMap(route => route.paramMap)
    ).subscribe(params => {
      this.idEstudiante = Number(params.get('idEstudiante'));
      this.chequearURL(this.router.url);
    });
  }

  chequearURL(url: string) {
    // Lista de rutas donde no se debe mostrar la nav bar
    const rutasBloqueadas = ['', '/registro', ':idAdmin/fixture/update'];
    this.mostrarNavBar = !rutasBloqueadas.includes(url);
  }


  logout() {

    this.router.navigate(['']);
  }

}
