import { Component, OnInit } from '@angular/core';
import { AppRoutes, AppTriggerModel } from "../app-route.model"
import { AppRouteService } from "../app-route.service"

@Component({
  selector: 'mw-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  routeConfig: AppRoutes;
  modalConfig: AppTriggerModel;
  private localSearch: boolean = false;

  constructor(private appRouteService: AppRouteService) { }

  ngOnInit() {
    this.routeConfig = this.appRouteService.getRouteConfig();
    this.modalConfig = this.appRouteService.getModalConfig();
  }

  setLocalSearch(status) {
    this.localSearch = status;
  }
}
