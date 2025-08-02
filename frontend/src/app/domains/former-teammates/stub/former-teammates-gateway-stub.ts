import {Injectable, signal, Signal, WritableSignal} from '@angular/core';
import {FormerTeammatesGateway} from '../former-teammates-gateway';
import {UUID} from '@app/shared/types/uuid';
import {CreateFormerTeammate} from '../dto/payloads/createFormerTeammate';
import {UpdateFormerTeammate} from '../dto/payloads/updateFormerTeammate';
import {FormerTeammate} from '../former-teammates';
import {httpResource, HttpResourceRef} from '@angular/common/http';
import {Observable} from 'rxjs';
import {FormerTeammateDTO} from '@app/domains/former-teammates/dto/responses/former-teammate-dto';

@Injectable({
  providedIn: 'root'
})
export class FormerTeammatesGatewayStub implements FormerTeammatesGateway {
    private mockData: FormerTeammate[] = [
        {
            id: '550e8400-e29b-41d4-a716-446655440001',
            firstName: 'Jean',
            lastName: 'Dupont',
            phone: '+33123456789',
            email: 'jean.dupont@email.com',
            birthDate: '1990-05-15',
            roles: ['PLAYER'],
            status: 'VALIDATED'
        },
        {
            id: '550e8400-e29b-41d4-a716-446655440002',
            firstName: 'Marie',
            lastName: 'Martin',
            phone: '+33987654321',
            email: 'marie.martin@email.com',
            birthDate: '1988-12-03',
            roles: ['COACH', 'PLAYER'],
            status: 'PENDING'
        },
        {
            id: '550e8400-e29b-41d4-a716-446655440003',
            firstName: 'Pierre',
            lastName: 'Durand',
            email: 'pierre.durand@email.com',
            birthDate: '1985-08-22',
            roles: ['PRESIDENT'],
            status: 'SUBMITTED'
        },
        {
            id: '550e8400-e29b-41d4-a716-446655440004',
            firstName: 'Sophie',
            lastName: 'Leroy',
            phone: '+33555666777',
            roles: ['ASSISTANT'],
            status: 'NOT_REQUESTED'
        }
    ];

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
      console.log('getFormerTeammates');
        return this.stubItemResourceRef ;
    }
}
