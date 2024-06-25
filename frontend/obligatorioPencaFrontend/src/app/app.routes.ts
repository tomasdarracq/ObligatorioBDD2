import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PencaComponent } from './penca/penca.component';
import { RegistroComponent } from './registro/registro.component';
import { PartidoComponent } from './partido/partido.component';
import { RankingComponent } from './ranking/ranking.component';
import { CampeonComponent } from './campeon/campeon.component';

export const routes: Routes = [
    { path: '', component: LoginComponent, data: { esconderNavBar: true }  },
    { path: 'register', component: RegistroComponent, data: { esconderNavBar: true }  },
    { path: ':idEstudiante/fixture', component: PencaComponent, data: { esconderNavBar: false } },
    { path: ':idAdmin/fixture/update', component: PartidoComponent, data: { esconderNavBar: true }  },
    { path: ':idEstudiante/ranking', component: RankingComponent, data: { esconderNavBar: false }  },
    {path:  ':idAdmin/fixture/update/champion', component: CampeonComponent, data: { esconderNavBar: true }  }
];
