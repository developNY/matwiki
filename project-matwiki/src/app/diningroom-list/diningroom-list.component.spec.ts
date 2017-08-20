import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiningroomListComponent } from './diningroom-list.component';

describe('DiningroomListComponent', () => {
  let component: DiningroomListComponent;
  let fixture: ComponentFixture<DiningroomListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiningroomListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiningroomListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
