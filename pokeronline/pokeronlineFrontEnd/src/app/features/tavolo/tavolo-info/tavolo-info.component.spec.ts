import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TavoloInfoComponent } from './tavolo-info.component';

describe('TavoloInfoComponent', () => {
  let component: TavoloInfoComponent;
  let fixture: ComponentFixture<TavoloInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TavoloInfoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TavoloInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
