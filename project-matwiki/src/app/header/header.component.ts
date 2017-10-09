import { Observable, ObservableInput } from "rxjs/Observable";
import {Component, OnDestroy, OnInit} from '@angular/core';
import { AppRoutes, AppTriggerModels } from "../app-route.model";
import { AppRouteService } from "../app-route.service";
import {Subject} from "rxjs/Subject";

@Component({
  selector: 'mw-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  routeConfig: AppRoutes;
  modalConfig: AppTriggerModels;
  private localSearch: boolean = false;

  //modal trigger
  searchModalTrigger: Subject<boolean> = new Subject();



  constructor(private appRouteService: AppRouteService) { }

  ngOnInit() {
    this.routeConfig = this.appRouteService.getRouteConfig();
    this.modalConfig = this.appRouteService.getModalConfig();
  }

  setLocalSearch(status) {
    this.localSearch = status;
  }
}
