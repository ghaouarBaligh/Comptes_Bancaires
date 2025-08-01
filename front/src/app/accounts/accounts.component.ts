import { Component, OnInit, ViewChild } from '@angular/core';
import { CompteBancaire } from '../models/compteBancaire.model';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { AccountsListComponent } from './accounts-list/accounts-list.component';
import { AccountsService } from '../services/accounts.service';
import { MatDialog } from '@angular/material/dialog';
import { AccountAjoutComponent } from './account-ajout/account-ajout.component';
import { AccountModifComponent } from './account-modif/account-modif.component';

@Component({
  selector: 'app-accounts',
  standalone: true,
  imports: [CommonModule,MatTableModule,MatPaginatorModule,AccountsListComponent],
  templateUrl: './accounts.component.html',
  styleUrl: './accounts.component.css'
})
export class AccountsComponent  {

  @ViewChild(AccountsListComponent) accountsListComponent!: AccountsListComponent;
  
    dataSource = new MatTableDataSource<CompteBancaire>();
    constructor(private accountsService: AccountsService, private dialog: MatDialog) {}
  
  
    openAjoutCompte() {
      const dialogRef = this.dialog.open(AccountAjoutComponent);
      dialogRef.afterClosed().subscribe(result => {
        if (result === true) {
          this.accountsListComponent.refreshComptes();
        }
      });    
    }

    modifierCompte(compte: any): void {
  const dialogRef = this.dialog.open(AccountModifComponent, {
    width: '500px',
    data: { ...compte }  // on envoie le compte à modifier
  });

  dialogRef.afterClosed().subscribe(result => {
    if (result) {
      // mettre à jour le compte dans le tableau, selon result
      const index = this.dataSource.data.findIndex(c => c.id === result.id);
      if (index !== -1) {
        this.dataSource.data[index] = result;
        this.dataSource.data = [...this.dataSource.data]; // pour déclencher le refresh
      }
    }
  });
}

  
}
