import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StockSectionComponent } from './stock-section.component';

describe('StockSectionComponent', () => {
  let component: StockSectionComponent;
  let fixture: ComponentFixture<StockSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StockSectionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StockSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
