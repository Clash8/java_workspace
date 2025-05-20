import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RuoloInfoComponent } from './ruolo-info.component';

describe('RuoloInfoComponent', () => {
  let component: RuoloInfoComponent;
  let fixture: ComponentFixture<RuoloInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RuoloInfoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RuoloInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
