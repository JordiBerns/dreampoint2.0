import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayingfieldListComponent } from './playingfield-list.component';

describe('PlayingfieldListComponent', () => {
  let component: PlayingfieldListComponent;
  let fixture: ComponentFixture<PlayingfieldListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayingfieldListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayingfieldListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
