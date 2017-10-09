import { Component,  OnDestroy, Input, ElementRef, AfterViewInit } from '@angular/core';
import {Subject} from "rxjs/Subject";
import {interpolateParams} from "@angular/animations/browser/src/util";



@Component({
  selector: 'mw-modal',
  templateUrl: 'modal.component.html',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent implements OnDestroy, AfterViewInit  {

  @Input() modalId:string;
  @Input() modalTrigger: Subject<Boolean>;
  @Input() className: string;

  protected tw: any = (<any>window).twCom;
  protected modal: any;
  constructor(private el: ElementRef) {}

  ngAfterViewInit() {
    const componentElement: HTMLElement = this.el.nativeElement;
    const modalElement: HTMLElement = componentElement.querySelector(`#${this.modalId}`) as HTMLElement;

    if(modalElement && this.tw && this.modalTrigger) {
      this.modal = this.tw.Modal.init(modalElement);
      this.modalTrigger.subscribe(data => data ? this.modal.openModal() : this.modal.closeModal());
    }
  }

  closeModal() {
    if(this.modalTrigger) {
      this.modalTrigger.next(false);
    }
  }

  ngOnDestroy() {
    if(this.modalTrigger) {
      this.modalTrigger.unsubscribe();
    }
  }
}
