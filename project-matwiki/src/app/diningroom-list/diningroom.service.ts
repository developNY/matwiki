import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { dummyData } from "./dummyData";


@Injectable()
export class DiningroomService {

  diningRoomList = dummyData;

  constructor(private http: Http) {
    console.log(http);
  }

  getDiningRoomList() {
    return this.diningRoomList;
  }
}
