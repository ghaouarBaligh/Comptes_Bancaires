import { Component, Inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MAT_DIALOG_DATA, MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { CompteBancaire } from '../../models/compteBancaire.model';

@Component({
  selector: 'app-account-modif',
  standalone: true,
  imports: [MatDialogModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule],
  templateUrl: './account-modif.component.html',
  styleUrl: './account-modif.component.css'
})
export class AccountModifComponent {

  nouveauCompte: CompteBancaire;

  constructor(
    public dialogRef: MatDialogRef<AccountModifComponent>,
    @Inject(MAT_DIALOG_DATA) public data: CompteBancaire
  ) {
    this.nouveauCompte = {...data};
  }
  
  enregistrerCompte() {
    if (!this.nouveauCompte.solde || !this.nouveauCompte.etat) {
      return;
    }
    this.dialogRef.close(this.nouveauCompte);
  }

  annuler() {
    this.dialogRef.close(null); 
  }

}
