import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PencaComponent } from './penca/penca.component';
import { RegistroComponent } from './registro/registro.component';
import { PartidoComponent } from './partido/partido.component';
import { RankingComponent } from './ranking/ranking.component';

export const routes: Routes = [
    { path: '', component: LoginComponent, data: { esconderNavBar: true }  },
    { path: 'registro', component: RegistroComponent, data: { esconderNavBar: true }  },
    { path: ':idEstudiante/fixture', component: PencaComponent, data: { esconderNavBar: false } },
    { path: ':idAdmin/fixture/update', component: PartidoComponent, data: { esconderNavBar: false }  },
    { path: ':idEstudiante/ranking', component: RankingComponent, data: { esconderNavBar: false }  },
];
