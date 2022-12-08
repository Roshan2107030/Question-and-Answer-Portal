import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListSubQnAsComponent } from './list-subQnAs.component';

describe('ListSubQnAsComponent', () => {
  let component: ListSubQnAsComponent;
  let fixture: ComponentFixture<ListSubQnAsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListSubQnAsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListSubQnAsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
