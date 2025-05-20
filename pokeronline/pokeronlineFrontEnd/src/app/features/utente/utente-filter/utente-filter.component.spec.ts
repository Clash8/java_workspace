import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UtenteFilterComponent } from './utente-filter.component';

describe('UtenteFilterComponent', () => {
  let component: UtenteFilterComponent;
  let fixture: ComponentFixture<UtenteFilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UtenteFilterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UtenteFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
