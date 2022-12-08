import { TestBed } from '@angular/core/testing';

import { SubQnAService } from './subQnA.service';

describe('SubQnAService', () => {
  let service: SubQnAService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubQnAService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
