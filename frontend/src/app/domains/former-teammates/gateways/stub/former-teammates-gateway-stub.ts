import {Injectable} from '@angular/core';
import {FormerTeammatesGateway} from '../former-teammates-gateway';
import {UUID} from '@app/shared/types/uuid';
import {CreateFormerTeammate} from '../../dto/payloads/createFormerTeammate';
import {UpdateFormerTeammate} from '../../dto/payloads/updateFormerTeammate';
import {FormerTeammate} from '../../models/former-teammates';
import {httpResource, HttpResourceRef} from '@angular/common/http';
import {Observable} from 'rxjs';
import {FormerTeammateDTO} from '@app/domains/former-teammates/dto/responses/former-teammate-dto';

@Injectable({
  providedIn: 'root'
})
export class FormerTeammatesGatewayStub implements FormerTeammatesGateway {


    private stubItemResourceRef: HttpResourceRef<FormerTeammate[] |  undefined> = httpResource(() => '')

    constructor() {
      this.stubItemResourceRef.set(this.mockData)


    }

  createFormerTeammate(createFormerTeammate: CreateFormerTeammate): Observable<FormerTeammateDTO> {
        throw new Error('Method not implemented.');
    }
    updateFormerTeammate(updateFormerTeammate: UpdateFormerTeammate): Observable<FormerTeammateDTO> {
        throw new Error('Method not implemented.');
    }
    deleteFormerTeammate(formerTeammateId: UUID): Observable<void> {
        throw new Error('Method not implemented.');
    }
    getFormerTeammates(): HttpResourceRef<FormerTeammate[] |  undefined> {
        return this.stubItemResourceRef ;
    }

  private mockData: FormerTeammate[] = [
    {
      id: '550e8400-e29b-41d4-a716-446655440001',
      firstName: 'Jean',
      lastName: 'Dupont',
      gender: 'M',
      phone: '+33123456789',
      birthDate: new Date('1990-05-15'),
      roles: [],
      status: 'VALIDATED'
    },
    {
      id: '550e8400-e29b-41d4-a716-446655440002',
      firstName: 'Marie',
      lastName: 'Martin',
      gender: 'M',
      phone: '+33987654321',
      birthDate: new Date('1988-12-03'),
      roles: ['COACH', 'PLAYER'],
      status: 'PENDING'
    },
    {
      id: '550e8400-e29b-41d4-a716-446655440003',
      firstName: 'Sébastien',
      lastName: 'Burckhardt',
      gender: 'M',
      birthDate: new Date('1985-08-22'),
      roles: ['PRESIDENT'],
      status: 'SUBMITTED'
    },
    {
      id: '550e8400-e29b-41d4-a716-446655440004',
      firstName: 'Sophie',
      lastName: 'Leroy',
      gender: 'F',
      phone: '+33555666777',
      roles: ['ASSISTANT'],
      status: 'NOT_REQUESTED'
    }
  ];
}
