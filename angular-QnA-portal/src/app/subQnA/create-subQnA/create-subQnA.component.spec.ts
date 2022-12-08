import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSubQnAComponent } from './create-subQnA.component';

describe('CreateSubQnAComponent', () => {
  let component: CreateSubQnAComponent;
  let fixture: ComponentFixture<CreateSubQnAComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateSubQnAComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSubQnAComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
