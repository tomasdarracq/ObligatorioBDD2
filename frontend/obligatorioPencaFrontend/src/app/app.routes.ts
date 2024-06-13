import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PencaComponent } from './penca/penca.component';
import { RegistroComponent } from './registro/registro.component';
import { PartidoComponent } from './partido/partido.component';
import { RankingComponent } from './ranking/ranking.component';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: ':idEstudiante/fixture', component: PencaComponent },
    { path: ':idAdmin/fixture/update', component: PartidoComponent },
    { path: 'registro', component: RegistroComponent },
    { path: 'ranking', component: RankingComponent },
];
