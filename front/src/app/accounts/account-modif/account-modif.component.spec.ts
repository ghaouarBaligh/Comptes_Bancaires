import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountModifComponent } from './account-modif.component';

describe('AccountModifComponent', () => {
  let component: AccountModifComponent;
  let fixture: ComponentFixture<AccountModifComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AccountModifComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AccountModifComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
