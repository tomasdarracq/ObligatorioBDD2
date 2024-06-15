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

  constructor(private router: Router, private activatedRoute: ActivatedRoute) {
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
  }

  chequearURL(url: string) {
    // Lista de rutas donde no se debe mostrar la nav bar
    const rutasBloqueadas = ['', '/registro'];
    this.mostrarNavBar = !rutasBloqueadas.includes(url);
  }


  logout() {
    // Perform logout logic here (e.g., clear authentication tokens, etc.)
    // Then navigate to the login page or home page
    this.router.navigate(['/login']);
  }


}
