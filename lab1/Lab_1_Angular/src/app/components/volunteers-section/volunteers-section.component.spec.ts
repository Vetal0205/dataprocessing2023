import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VolunteersSectionComponent } from './volunteers-section.component';

describe('VolunteersSectionComponent', () => {
  let component: VolunteersSectionComponent;
  let fixture: ComponentFixture<VolunteersSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VolunteersSectionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VolunteersSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
