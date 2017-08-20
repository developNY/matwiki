import { AppRoutes, AppTriggerModel } from './app-route.model';import { DiningroomListComponent } from "./diningroom-list/diningroom-list.component";import { DiningroomDetailComponent } from "./diningroom-list/diningroom-detail/diningroom-detail.component";export const routesConfig: AppRoutes = [  {    path: '',    redirectTo: '/diningrooms',    pathMatch: 'full',    mwHeader: true,    mwMenuType: 'title',    mwClass: 'title',    mwText: 'Mat Wiki'  },  {    path: 'diningrooms',    component: DiningroomListComponent  },  {    path: 'diningrooms/:roomId',    component: DiningroomDetailComponent  },];export const modalsConfig: AppTriggerModel = [  {    mwHeader: true,    mwMenuType: 'modal-menu',    mwClass: 'waves-effect',    mwHTML: '<i class="fa fa-plus" aria-hidden="true"></i>',  },  {    mwHeader: true,    mwMenuType: 'modal-menu',    mwClass: 'waves-effect',    mwHTML: '<i class="fa fa-user" aria-hidden="true"></i>  ',  },  {    mwHeader: true,    mwMenuType: 'modal-menu',    mwClass: 'waves-effect',    mwHTML: '<i class="fa fa-search" aria-hidden="true"></i>',  },];