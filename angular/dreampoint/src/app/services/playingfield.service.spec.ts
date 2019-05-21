import { TestBed } from '@angular/core/testing';

import { PlayingfieldService } from './playingfield.service';

describe('PlayingfieldService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PlayingfieldService = TestBed.get(PlayingfieldService);
    expect(service).toBeTruthy();
  });
});
