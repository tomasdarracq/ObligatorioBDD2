import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PencaComponent } from './penca/penca.component';
import { RegistroComponent } from './registro/registro.component';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    // { path: '', component:PencaComponent },
    { path: 'penca', component: PencaComponent },
    { path: 'regis.tro', component: RegistroComponent },

];
