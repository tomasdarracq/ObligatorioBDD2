import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PencaComponent } from './penca/penca.component';
import { RegistroComponent } from './registro/registro.component';
import { PartidoComponent } from './partido/partido.component';
import { RankingComponent } from './ranking/ranking.component';
import { CampeonComponent } from './campeon/campeon.component';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'register', component: RegistroComponent },
    { path: ':idEstudiante/fixture', component: PencaComponent },
    { path: ':idAdmin/fixture/update', component: PartidoComponent },
    { path: ':idEstudiante/ranking', component: RankingComponent },
    { path:  ':idAdmin/fixture/update/champion', component: CampeonComponent }
];
