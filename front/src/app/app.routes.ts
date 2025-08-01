import { Routes } from '@angular/router';
import { AccountsComponent } from './accounts/accounts.component';
import { CustomerComponent } from './customer/customer.component';
import { AccountModifComponent } from './accounts/account-modif/account-modif.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    {path:"home", component: HomeComponent},
    {path:"customers", component: CustomerComponent},
    {path:"accounts",component:AccountsComponent},
    {path:"about",component:AboutComponent},
    {path:"modif",component:AccountModifComponent},

];
