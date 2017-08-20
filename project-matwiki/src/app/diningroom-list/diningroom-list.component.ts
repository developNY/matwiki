import { Component, OnInit } from '@angular/core';
import { DiningroomService } from "./diningroom.service"
import { DiningroomModel, ReviewModel } from "./diningroom.model";
@Component({
  selector: 'mw-diningroom-list',
  templateUrl: './diningroom-list.component.html',
  styleUrls: ['./diningroom-list.component.scss']
})
export class DiningroomListComponent implements OnInit {


  diningRoomList: any;

  constructor(private diningRoomService: DiningroomService) { }

  ngOnInit() {
    this.diningRoomList = this.diningRoomService.getDiningRoomList().DATA;
    console.log(this.diningRoomList);
  }

}
