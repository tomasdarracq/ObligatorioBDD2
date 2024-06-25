import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-admin-nav-bar',
  standalone: true,
  imports: [],
  templateUrl: './admin-nav-bar.component.html',
  styleUrl: './admin-nav-bar.component.css'
})
export class AdminNavBarComponent {
  idAdmin!: number;

  constructor(private router: Router, private activatedRoute: ActivatedRoute) {

  }

  ngOnInit() {
    this.idAdmin = Number(this.activatedRoute.snapshot.paramMap.get('idAdmin'));
    console.log(this.idAdmin);
  }

  logout() {
    this.router.navigate(['']);
  }

}
