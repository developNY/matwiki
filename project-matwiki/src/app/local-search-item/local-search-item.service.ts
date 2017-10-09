import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { localSearchItem } from "./local-search-item.model";
@Injectable()
export class LocalSearchItemService {

  private items: localSearchItem[] = [
    {
      name: 'test1',
      detailAddr: 'test1detail'
    },
    {
      name: 'test2',
      detailAddr: 'test2detail'
    },
    {
      name: 'test3',
      detailAddr: 'test3detail'
    },
    {
      name: 'test4',
      detailAddr: 'test4detail'
    },
    {
      name: 'test5',
      detailAddr: 'test5detail'
    },
    {
      name: 'test6',
      detailAddr: 'test6detail'
    }
  ];

  constructor(private http: Http) {
    console.log('http load', http);
  }

  getSearchItems() {
    return this.items;
  }
}
