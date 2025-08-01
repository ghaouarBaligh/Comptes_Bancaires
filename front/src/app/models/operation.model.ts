import { typeOperation } from "./typeOperation.model";

export interface Operation {
  id?: number;                // correspond à Long id
  dateOperation?: Date;       // correspond à Date dateOperation
  montant?: number;           // correspond à double montant
  type?: typeOperation;       // correspond à TypeOperation type (tu dois créer aussi ce type)
}
