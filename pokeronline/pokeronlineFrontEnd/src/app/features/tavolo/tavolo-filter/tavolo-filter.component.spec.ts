import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TavoloFilterComponent } from './tavolo-filter.component';

describe('TavoloFilterComponent', () => {
  let component: TavoloFilterComponent;
  let fixture: ComponentFixture<TavoloFilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TavoloFilterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TavoloFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
