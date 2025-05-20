import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TavoloListComponent } from './tavolo-list.component';

describe('TavoloListComponent', () => {
  let component: TavoloListComponent;
  let fixture: ComponentFixture<TavoloListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TavoloListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TavoloListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
