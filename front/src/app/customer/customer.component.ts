import { Component, ViewChild } from '@angular/core';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerAjoutComponent } from '../customer-ajout/customer-ajout.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { CommonModule } from '@angular/common';
import { CustomersService } from '../services/customers.service';
import { MatDialogModule, MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { Customer } from '../models/customer.model';

@Component({
  selector: 'app-customer',
  standalone: true,
  imports: [CommonModule,CustomerListComponent, CustomerAjoutComponent,MatFormFieldModule, MatInputModule],
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.css'
})
export class CustomerComponent {

  @ViewChild(CustomerListComponent) customerListComponent!: CustomerListComponent;

  dataSource = new MatTableDataSource<Customer>();
  constructor(private clientService: CustomersService, private dialog: MatDialog) {}


  openAjoutClient() {
    const dialogRef = this.dialog.open(CustomerAjoutComponent);
    dialogRef.afterClosed().subscribe(result => {
      if (result === true) {
        this.customerListComponent.refreshClients();
          }
        });
  }

}
