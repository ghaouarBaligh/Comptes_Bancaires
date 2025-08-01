import { Component, Inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MAT_DIALOG_DATA, MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { Customer } from '../../models/customer.model';

@Component({
  selector: 'app-customer-modif',
  standalone: true,
  imports: [MatDialogModule,
      FormsModule,
      MatFormFieldModule,
      MatInputModule,
      MatSelectModule,
      MatButtonModule],
  templateUrl: './customer-modif.component.html',
  styleUrl: './customer-modif.component.css'
})
export class CustomerModifComponent {

  
    nouveauCustomer: Customer;
  
    constructor(
      public dialogRef: MatDialogRef<CustomerModifComponent>,
      @Inject(MAT_DIALOG_DATA) public data: Customer
    ) {
      this.nouveauCustomer = {...data};
    }
    
    enregistrerCustomer() {
      if (!this.nouveauCustomer.nom || !this.nouveauCustomer.prenom || !this.nouveauCustomer.email) {
        return;
      }
      this.dialogRef.close(this.nouveauCustomer);
    }
  
    annuler() {
      this.dialogRef.close(null); 
    }

}
