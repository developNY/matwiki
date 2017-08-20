import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpModule } from "@angular/http"
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { DiningroomListComponent } from './diningroom-list/diningroom-list.component';
import { DiningroomDetailComponent } from './diningroom-list/diningroom-detail/diningroom-detail.component';
import { DiningroomService } from "./diningroom-list/diningroom.service";
import { ModalComponent } from './modal/modal.component';
import { AsdComponent } from './asd/asd.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DiningroomListComponent,
    DiningroomDetailComponent,
    ModalComponent,
    AsdComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [DiningroomService],
  bootstrap: [AppComponent]
})
export class AppModule { }
