import { Component, OnInit, OnDestroy, Input, ElementRef } from '@angular/core';



@Component({
  selector: 'mw-modal',
  template: '<ng-content></ng-content>',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent implements OnInit, OnDestroy {

  @Input() id:string;
  private win: any = window;
  private Modal: object;
  constructor(private el: ElementRef) {
  }



  ngOnInit() {
    var element = this.el.nativeElement;
    var twCom = this.win.twCom;
    var id = element.getAttribute('id');

    if(!id) {
      throw new Error('id 속성이 존재하지않습니다.');
    }

    // var modal = element.querySelector('.modal');
    // modal.setAttribute('id', id);
    // this.Modal = twCom.Modal.init(modal);
  }


  ngOnDestroy() {

  }

}
