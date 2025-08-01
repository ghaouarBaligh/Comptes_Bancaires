import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerAjoutComponent } from './customer-ajout.component';

describe('CustomerAjoutComponent', () => {
  let component: CustomerAjoutComponent;
  let fixture: ComponentFixture<CustomerAjoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CustomerAjoutComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerAjoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
