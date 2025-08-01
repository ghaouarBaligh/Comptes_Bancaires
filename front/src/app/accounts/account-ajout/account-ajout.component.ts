import { Component, inject } from '@angular/core';
import { AccountsService } from '../../services/accounts.service';
import { MatDialogRef } from '@angular/material/dialog';
import { CompteStatus } from '../../models/compteBancaire.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSelectModule } from '@angular/material/select';
import { CustomersService } from '../../services/customers.service';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-account-ajout',
  standalone: true,
  imports: [CommonModule, FormsModule, MatFormFieldModule, MatInputModule, MatDatepickerModule, MatNativeDateModule, MatSelectModule,MatIconModule  ],
  templateUrl: './account-ajout.component.html',
  styleUrl: './account-ajout.component.css'
})
export class AccountAjoutComponent {

  displayedColumns: string[] = ['id', 'dateCreation', 'solde', 'etat', 'client'];

  clients: any[] = []; // ou Customer[] si tu as un modèle

  constructor(private customerService:CustomersService) {
    this.customerService.getClients().subscribe({
      next: (data) => this.clients = data,
      error: () => alert("Erreur lors du chargement des clients")
    });
  }

  accountsService = inject(AccountsService);
  dialogRef = inject(MatDialogRef<AccountAjoutComponent>);
  selectedClientId!: number;

  nouveauCompte = {
    dateCreation: new Date(),
    solde: 0,
    etat: CompteStatus.ACTIVE,
    client: undefined as any,       
    operation: [] 
  };
  
  ajouterCompte() {
    this.nouveauCompte.client = { id: this.selectedClientId };
    console.log('Données envoyées :', this.nouveauCompte);

    this.accountsService.createCompte(this.nouveauCompte).subscribe({
      next: () => this.dialogRef.close(true),
      error: (err) => {
    console.error('Erreur complète :', err);
    alert("Erreur lors de l'ajout du compte.");
  }

  });
}


}
