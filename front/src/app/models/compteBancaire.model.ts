import { Customer } from "./customer.model";
import { Operation } from "./operation.model";


export enum CompteStatus {
  ACTIVE = 'ACTIVE',
  CLOSED = 'CLOSED',
  SUSPENDED = 'SUSPENDED',
  // ajoute d'autres états si besoin
}

export interface CompteBancaire {
  id?: number;
  dateCreation?: Date;
  solde?: number;
  etat?: CompteStatus;
  client?: Customer;
  operation?: Operation[];
}
