import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RuoloListComponent } from './ruolo-list.component';

describe('RuoloListComponent', () => {
  let component: RuoloListComponent;
  let fixture: ComponentFixture<RuoloListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RuoloListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RuoloListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
