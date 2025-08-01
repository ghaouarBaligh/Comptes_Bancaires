import { Component, OnInit, ViewChild } from '@angular/core';
import { Customer } from '../../models/customer.model';
import { CustomersService } from '../../services/customers.service';
import { CommonModule } from '@angular/common';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatPaginatorModule, MatPaginator } from '@angular/material/paginator';
import { AccountsService } from '../../services/accounts.service';
import { MatIconModule } from '@angular/material/icon';
import { CustomerModifComponent } from '../customer-modif/customer-modif.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-customer-list',
  standalone: true,
  imports: [CommonModule,MatTableModule,MatPaginatorModule,MatIconModule],
  templateUrl: './customer-list.component.html',
  styleUrl: './customer-list.component.css'
})
export class CustomerListComponent implements OnInit{

  displayedColumns: string[] = ['id','nom', 'prenom', 'email','action'];
  dataSource = new MatTableDataSource<Customer>();

  clients: Customer[]=[];
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private customerService : CustomersService,private dialog: MatDialog){}

  ngOnInit(): void {
    this.customerService.getClients().subscribe({
      next:(resultat) => {this.dataSource.data = resultat},
      error:(error) => {console.log('problème chargement')}
    })
  }
  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }

  refreshClients() {
    this.customerService.getClients().subscribe({
      next: (resultat) => this.dataSource.data = resultat,
      error: () => console.log('Erreur de chargement')
    });
  }

  confirmerSuppression(customer: any) {
      if (confirm(`Voulez-vous vraiment supprimer le customer #${customer.id} ?`)) {
        this.supprimerCustomer(customer);
      }
    }

    supprimerCustomer(customer: any) {
      this.customerService.deleteClientById(customer.id).subscribe({
        next: () => {
          this.dataSource.data = this.dataSource.data.filter(c => c.id !== customer.id);
          alert('Customer supprimé avec succès');
        },
        error: err => {
          console.error(err);
          alert('Erreur lors de la suppression');
        }
      });
    }

     modifierCustomer(customer: Customer) {
      const dialogRef = this.dialog.open(CustomerModifComponent, {
        width: '400px',
        data: customer  // on passe le compte à modifier
      });
    
      dialogRef.afterClosed().subscribe(result => {
        if (result) {
          // result contient les nouvelles données modifiées
          this.customerService.updateClient(result.id,result).subscribe(() => {
            this.refreshClients(); // recharge la liste pour afficher les changements
          });
        }
      });
    }

}
