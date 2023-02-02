import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManpadTemplateComponent } from './manpad-template.component';

describe('ManpadTemplateComponent', () => {
  let component: ManpadTemplateComponent;
  let fixture: ComponentFixture<ManpadTemplateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManpadTemplateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManpadTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
