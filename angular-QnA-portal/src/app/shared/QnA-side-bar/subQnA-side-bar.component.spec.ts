import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubQnASideBarComponent } from './subQnA-side-bar.component';

describe('SubQnASideBarComponent', () => {
  let component: SubQnASideBarComponent;
  let fixture: ComponentFixture<SubQnASideBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubQnASideBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubQnASideBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
