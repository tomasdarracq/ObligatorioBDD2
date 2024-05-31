import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PencaComponent } from './penca/penca.component';
import { RegistroComponent } from './registro/registro.component';
import { PartidoComponent } from './partido/partido.component';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    // { path: '', component:PencaComponent },
    { path: 'fixture', component: PencaComponent },
    {path: 'fixture/update', component: PartidoComponent},
    { path: 'registro', component: RegistroComponent },

];
