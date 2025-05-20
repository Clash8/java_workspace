import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UtenteInfoComponent } from './utente-info.component';

describe('UtenteInfoComponent', () => {
  let component: UtenteInfoComponent;
  let fixture: ComponentFixture<UtenteInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UtenteInfoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UtenteInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
