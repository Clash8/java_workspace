import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RuoloFilterComponent } from './ruolo-filter.component';

describe('RuoloFilterComponent', () => {
  let component: RuoloFilterComponent;
  let fixture: ComponentFixture<RuoloFilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RuoloFilterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RuoloFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
