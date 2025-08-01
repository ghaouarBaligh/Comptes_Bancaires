import { Component, OnInit, ViewChild } from '@angular/core';
import { CompteBancaire } from '../../models/compteBancaire.model';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { AccountsService } from '../../services/accounts.service';
import { MatIconModule } from '@angular/material/icon';
import { RouterModule } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { AccountModifComponent } from '../account-modif/account-modif.component';

@Component({
  selector: 'app-accounts-list',
  standalone: true,
  imports: [CommonModule,MatTableModule,MatPaginatorModule, MatIconModule,RouterModule],
  templateUrl: './accounts-list.component.html',
  styleUrl: './accounts-list.component.css'
})
export class AccountsListComponent implements OnInit {


    comptes: CompteBancaire[]=[];
    displayedColumns: string[] = ['Id', 'dateCreation', 'solde', 'etat', 'client','action'];
  
    dataSource = new MatTableDataSource<CompteBancaire>();
    @ViewChild(MatPaginator) paginator!: MatPaginator;
  
  
    constructor(private accountsService: AccountsService,private dialog: MatDialog){}
  
    ngOnInit(): void {
    this.accountsService.getComptes().subscribe({
      next:(resultat) => {this.dataSource.data = resultat},
      error:(error) => {console.log('problème chargement')}
    })
  }
  
    ngAfterViewInit(): void {
      this.dataSource.paginator = this.paginator;
    }

    refreshComptes() {
      this.accountsService.getComptes().subscribe({
        next: (resultat) => this.dataSource.data = resultat,
        error: () => console.log('Erreur de chargement')
      });
    }

    confirmerSuppression(compte: any) {
      if (confirm(`Voulez-vous vraiment supprimer le compte #${compte.id} ?`)) {
        this.supprimerCompte(compte);
      }
    }

    supprimerCompte(compte: any) {
      this.accountsService.deleteCompte(compte.id).subscribe({
        next: () => {
          this.dataSource.data = this.dataSource.data.filter(c => c.id !== compte.id);
          alert('Compte supprimé avec succès');
        },
        error: err => {
          console.error(err);
          alert('Erreur lors de la suppression');
        }
      });
    }

    modifierCompte(compte: CompteBancaire) {
  const dialogRef = this.dialog.open(AccountModifComponent, {
    width: '400px',
    data: compte  // on passe le compte à modifier
  });

  dialogRef.afterClosed().subscribe(result => {
    if (result) {
      // result contient les nouvelles données modifiées
      this.accountsService.updateCompte(result.id,result).subscribe(() => {
        this.refreshComptes(); // recharge la liste pour afficher les changements
      });
    }
  });
}



}
