import { TestBed } from '@angular/core/testing';

import { GetManpadsService } from './get-manpads.service';

describe('GetManpadsService', () => {
  let service: GetManpadsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetManpadsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
