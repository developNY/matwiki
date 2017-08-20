import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { routesConfig } from './app-route.config';
import { AppRouteService } from './app-route.service';

@NgModule({
  imports: [RouterModule.forRoot(routesConfig)],
  exports: [RouterModule],
  providers: [AppRouteService]
})
export class AppRoutingModule { }
