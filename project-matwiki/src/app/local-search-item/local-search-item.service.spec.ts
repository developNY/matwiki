import { TestBed, inject } from '@angular/core/testing';

import { LocalSearchItemService } from './local-search-item.service';

describe('LocalSearchItemService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LocalSearchItemService]
    });
  });

  it('should be created', inject([LocalSearchItemService], (service: LocalSearchItemService) => {
    expect(service).toBeTruthy();
  }));
});
