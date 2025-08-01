import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../models/customer.model';

@Injectable({
  providedIn: 'root'
})
export class CustomersService {
  private baseUrl = 'http://localhost:8080/bank_client';

  constructor(private http: HttpClient) { }

  getClients(): Observable<Customer[]>{
    return this.http.get<Customer[]>(`${this.baseUrl}/consulter`)
  }

  //Récupérer client par Id
  getClientById(id: number): Observable<Customer>{
    return this.http.get<Customer>(`${this.baseUrl}/consulter/${id}`);
  } 

  //Créer un nouveau client
  createClient(client: Customer): Observable<void>{
    return this.http.post<void>(`${this.baseUrl}/creer`,client);
  }

  //Mettre à jour le client
  updateClient(id: number, client: Customer): Observable<void>{
    return this.http.put<void>(`${this.baseUrl}/client/${id}`,client);
  }

  //Supprimer un client par id
  deleteClientById(id: number): Observable<void>{
    return this.http.delete<void>(`${this.baseUrl}/supprimer/${id}`);
  }
}
