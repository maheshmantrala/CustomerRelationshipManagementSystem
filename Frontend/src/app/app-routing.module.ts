import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from './components/login/login.component'
import { CustomerDashboardComponent } from './components/customer-dashboard/customer-dashboard.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { RegisterComponent } from './components/register/register.component';
import { CustomerinteractionsComponent } from './components/customerinteractions/customerinteractions.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
      { path: 'customerdashboard', component: CustomerDashboardComponent },
      { path: 'admindashboard', component: AdminDashboardComponent },
     { path: 'register', component: RegisterComponent },
     { path: 'customerinteractions', component: CustomerinteractionsComponent },
    { path: '', redirectTo: '/login', pathMatch: 'full' }, // Redirect to login by default
    { path: '**', redirectTo: '/login' } ,// Wildcard route to handle 404

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
