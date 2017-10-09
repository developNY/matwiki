import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LocalSearchItemComponent } from './local-search-item.component';

describe('LocalSearchItemComponent', () => {
  let component: LocalSearchItemComponent;
  let fixture: ComponentFixture<LocalSearchItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LocalSearchItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LocalSearchItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
