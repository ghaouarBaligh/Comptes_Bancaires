import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CompteBancaire } from '../models/compteBancaire.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountsService {

  private baseUrl = 'http://localhost:8080/bank_compte_bancaire';

  constructor(private http: HttpClient) {}

  // ✅ Créer un compte bancaire
  createCompte(compte: CompteBancaire): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/creer`, compte);
  }

  // ✅ Récupérer tous les comptes bancaires
  getComptes(): Observable<CompteBancaire[]> {
    return this.http.get<CompteBancaire[]>(`${this.baseUrl}/consulterComptes`);
  }

  // ✅ Récupérer un compte bancaire par ID
  getCompteById(id: number): Observable<CompteBancaire> {
    return this.http.get<CompteBancaire>(`${this.baseUrl}/consulter/${id}`);
  }

  // ✅ Modifier un compte bancaire
  updateCompte(id: number, compte: CompteBancaire): Observable<void> {
    return this.http.put<void>(`${this.baseUrl}/compte_bancaire/${id}`, compte);
  }

  // ✅ Supprimer un compte bancaire
  deleteCompte(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/supprimer/${id}`);
  }
}

