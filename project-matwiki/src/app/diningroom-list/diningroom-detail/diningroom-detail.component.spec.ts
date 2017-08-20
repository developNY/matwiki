import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiningroomDetailComponent } from './diningroom-detail.component';

describe('DiningroomDetailComponent', () => {
  let component: DiningroomDetailComponent;
  let fixture: ComponentFixture<DiningroomDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiningroomDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiningroomDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
