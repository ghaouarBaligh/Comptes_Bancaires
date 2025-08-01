import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountAjoutComponent } from './account-ajout.component';

describe('AccountAjoutComponent', () => {
  let component: AccountAjoutComponent;
  let fixture: ComponentFixture<AccountAjoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AccountAjoutComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AccountAjoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
