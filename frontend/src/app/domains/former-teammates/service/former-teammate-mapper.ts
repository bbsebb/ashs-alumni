import {Injectable} from '@angular/core';
import {FormerTeammateFormValue} from '@app/domains/former-teammates/components/former-form/former-form';
import {UUID} from '@app/shared/types/uuid';
import {UpdateFormerTeammate} from '@app/domains/former-teammates/dto/payloads/updateFormerTeammate';
import {FormerTeammate} from '@app/domains/former-teammates/models/former-teammates';
import {CreateFormerTeammate} from '@app/domains/former-teammates/dto/payloads/createFormerTeammate';

@Injectable({
  providedIn: 'root'
})
export class FormerTeammateMapper {


  public mapFormValueToUpdateFormerTeammate(formerTeammateFormValue: FormerTeammateFormValue, id: UUID): UpdateFormerTeammate {
    return {
      id: id,
      gender: formerTeammateFormValue.gender,
      firstName: formerTeammateFormValue.firstName,
      lastName: formerTeammateFormValue.lastName,
      phone: formerTeammateFormValue.phone,
      email: formerTeammateFormValue.email,
      birthDate: formerTeammateFormValue.birthDate,
      roles: formerTeammateFormValue.roles
    };
  }

  public mapFormerTeammateToFormerTeammateFormValue(formerTeammate: FormerTeammate): FormerTeammateFormValue {
    return {
      gender: formerTeammate.gender,
      firstName: formerTeammate.firstName,
      lastName: formerTeammate.lastName,
      phone: formerTeammate.phone || null,
      email: formerTeammate.email || null,
      birthDate: formerTeammate.birthDate || null,
      roles: formerTeammate.roles
    };
  }

  public mapFormValueToCreateFormerTeammate(formValue: FormerTeammateFormValue): CreateFormerTeammate {
    return {
      gender: formValue.gender,
      firstName: formValue.firstName,
      lastName: formValue.lastName,
      phone: formValue.phone,
      email: formValue.email,
      birthDate: formValue.birthDate,
      roles: formValue.roles
    };
  }

}
