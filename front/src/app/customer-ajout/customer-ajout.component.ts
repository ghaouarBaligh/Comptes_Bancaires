import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { CustomersService } from '../services/customers.service';
import { MatDialogRef } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Customer } from '../models/customer.model';
@Component({
  selector: 'app-customer-ajout',
  standalone: true,
  imports: [CommonModule,FormsModule,MatFormFieldModule, MatInputModule],
  templateUrl: './customer-ajout.component.html',
  styleUrl: './customer-ajout.component.css'
})
export class CustomerAjoutComponent {

  clientService = inject(CustomersService);
  dialogRef = inject(MatDialogRef<CustomerAjoutComponent>);

  nouveauClient = {
    nom: '',
    prenom: '',
    email: ''
  };

  ajouterClient() {
    this.clientService.createClient(this.nouveauClient).subscribe({
      next: () => {
        this.dialogRef.close(true); // ✅ on ferme le dialog et retourne "true"
      },
      error: () => {
        alert("Erreur lors de l'ajout du client.");
      }
    });
  }

}
