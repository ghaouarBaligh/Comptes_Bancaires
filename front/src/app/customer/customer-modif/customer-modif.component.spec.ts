import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerModifComponent } from './customer-modif.component';

describe('CustomerModifComponent', () => {
  let component: CustomerModifComponent;
  let fixture: ComponentFixture<CustomerModifComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CustomerModifComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerModifComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
