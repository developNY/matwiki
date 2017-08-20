import { TestBed, inject } from '@angular/core/testing';

import { DiningroomService } from './diningroom.service';

describe('DiningroomService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DiningroomService]
    });
  });

  it('should be created', inject([DiningroomService], (service: DiningroomService) => {
    expect(service).toBeTruthy();
  }));
});
