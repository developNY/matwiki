import { Component, OnInit } from '@angular/core';
import { localSearchItem } from './local-search-item.model';
import { LocalSearchItemService } from "./local-search-item.service";
@Component({
  selector: 'mw-local-search-item',
  templateUrl: './local-search-item.component.html',
  styleUrls: ['./local-search-item.component.scss']
})
export class LocalSearchItemComponent implements OnInit {

  items: localSearchItem[];

  constructor(private localSearchItemService: LocalSearchItemService) { }

  ngOnInit() {
    this.items = this.localSearchItemService.getSearchItems();
  }

}
