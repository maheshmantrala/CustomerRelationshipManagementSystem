import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerinteractionsComponent } from './customerinteractions.component';

describe('CustomerinteractionsComponent', () => {
  let component: CustomerinteractionsComponent;
  let fixture: ComponentFixture<CustomerinteractionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CustomerinteractionsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerinteractionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
