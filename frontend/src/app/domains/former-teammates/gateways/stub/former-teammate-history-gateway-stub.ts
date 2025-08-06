import {Injectable} from '@angular/core';
import {FormerTeammateHistoryGateway} from '@app/domains/former-teammates/gateways/former-teammate-history-gateway';
import {FormerTeammateHistory} from '@app/domains/former-teammates/models/former-teamate-history';
import {httpResource, HttpResourceRef} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FormerTeammateHistoryGatewayStub implements FormerTeammateHistoryGateway{

  private stubItemResourceRef: HttpResourceRef<FormerTeammateHistory[] |  undefined> = httpResource(() => '')

  constructor() {
    this.stubItemResourceRef.set(this.mockHistoryData)
  }


  getFormerTeammateHistories(): HttpResourceRef<FormerTeammateHistory[] | undefined> {
    return this.stubItemResourceRef;
  }


  private mockHistoryData: FormerTeammateHistory[] = [
    // History for Jean Dupont (550e8400-e29b-41d4-a716-446655440001)
    {
      id: '550e8400-e29b-41d4-a716-446655440101',
      contactId: '550e8400-e29b-41d4-a716-446655440001',
      action: 'CREATE',
      newValue: {
        id: '550e8400-e29b-41d4-a716-446655440001',
        firstName: 'Jean',
        lastName: 'Dupont',
        phone: '+33123456789',
        gender: 'M',
        birthDate: new Date('1990-05-15'),
        roles: ['PLAYER'],
        status: 'SUBMITTED'
      },
      changedAt: new Date('2024-01-15T10:30:00Z'),
      changedByUserId: '550e8400-e29b-41d4-a716-446655440999',
      changedByUserName: 'Dubois Michel'
    },
    {
      id: '550e8400-e29b-41d4-a716-446655440102',
      contactId: '550e8400-e29b-41d4-a716-446655440001',
      action: 'UPDATE',
      previousValue: {
        id: '550e8400-e29b-41d4-a716-446655440001',
        firstName: 'Jean',
        lastName: 'Dupont',
        gender: 'M',
        phone: '+33123456789',
        birthDate: new Date('1990-05-15'),
        roles: ['PLAYER'],
        status: 'SUBMITTED'
      },
      newValue: {
        id: '550e8400-e29b-41d4-a716-446655440001',
        firstName: 'Jean',
        lastName: 'Dupont',
        gender: 'M',
        phone: '+33123456789',
        birthDate: new Date('1990-05-15'),
        roles: ['PLAYER'],
        status: 'VALIDATED'
      },
      changedAt: new Date('2024-02-01T14:20:00Z'),
      changedByUserId: '550e8400-e29b-41d4-a716-446655440998',
      changedByUserName: 'Moreau Claire'
    },

    // History for Marie Martin (550e8400-e29b-41d4-a716-446655440002)
    {
      id: '550e8400-e29b-41d4-a716-446655440201',
      contactId: '550e8400-e29b-41d4-a716-446655440002',
      action: 'CREATE',
      newValue: {
        id: '550e8400-e29b-41d4-a716-446655440002',
        firstName: 'Marie',
        lastName: 'Martin',
        gender: 'F',
        phone: '+33987654321',
        birthDate: new Date('1988-12-03'),
        roles: ['PLAYER'],
        status: 'SUBMITTED'
      },
      changedAt: new Date('2024-01-20T09:15:00Z'),
      changedByUserId: '550e8400-e29b-41d4-a716-446655440999',
      changedByUserName: 'Dubois Michel'
    },
    {
      id: '550e8400-e29b-41d4-a716-446655440202',
      contactId: '550e8400-e29b-41d4-a716-446655440002',
      action: 'UPDATE',
      previousValue: {
        id: '550e8400-e29b-41d4-a716-446655440002',
        firstName: 'Marie',
        lastName: 'Martin',
        gender: 'F',
        phone: '+33987654321',
        birthDate: new Date('1988-12-03'),
        roles: ['PLAYER'],
        status: 'SUBMITTED'
      },
      newValue: {
        id: '550e8400-e29b-41d4-a716-446655440002',
        firstName: 'Marie',
        lastName: 'Martin',
        gender: 'M',
        phone: '+33987654321',
        birthDate: new Date('1988-12-03'),
        roles: ['COACH', 'PLAYER'],
        status: 'PENDING'
      },
      changedAt: new Date('2024-03-10T16:45:00Z'),
      changedByUserId: '550e8400-e29b-41d4-a716-446655440997',
      changedByUserName: 'Lefebvre Antoine'
    },

    // History for Pierre Durand (550e8400-e29b-41d4-a716-446655440003)
    {
      id: '550e8400-e29b-41d4-a716-446655440301',
      contactId: '550e8400-e29b-41d4-a716-446655440003',
      action: 'CREATE',
      newValue: {
        id: '550e8400-e29b-41d4-a716-446655440003',
        firstName: 'Pierre',
        lastName: 'Durand',
        gender: 'M',
        birthDate: new Date('1985-08-22'),
        roles: ['PRESIDENT'],
        status: 'SUBMITTED'
      },
      changedAt: new Date('2024-02-05T11:00:00Z'),
      changedByUserId: '550e8400-e29b-41d4-a716-446655440999',
      changedByUserName: 'Dubois Michel'
    },

    // History for Sophie Leroy (550e8400-e29b-41d4-a716-446655440004)
    {
      id: '550e8400-e29b-41d4-a716-446655440401',
      contactId: '550e8400-e29b-41d4-a716-446655440004',
      action: 'CREATE',
      newValue: {
        id: '550e8400-e29b-41d4-a716-446655440004',
        firstName: 'Sophie',
        lastName: 'Leroy',
        gender: 'F',
        phone: '+33555666777',
        roles: ['ASSISTANT'],
        status: 'NOT_REQUESTED'
      },
      changedAt: new Date('2024-03-01T08:30:00Z'),
      changedByUserId: '550e8400-e29b-41d4-a716-446655440999',
      changedByUserName: 'Dubois Michel'
    },

    // Example of a DELETE action
    {
      id: '550e8400-e29b-41d4-a716-446655440501',
      contactId: '550e8400-e29b-41d4-a716-446655440005',
      action: 'DELETE',
      previousValue: {
        id: '550e8400-e29b-41d4-a716-446655440005',
        firstName: 'Antoine',
        lastName: 'Bernard',
        gender: 'M',
        birthDate: new Date('1992-03-18'),
        roles: ['PLAYER'],
        status: 'VALIDATED'
      },
      newValue: {
        id: '550e8400-e29b-41d4-a716-446655440005',
        firstName: 'Antoine',
        lastName: 'Bernard',
        gender: 'M',
        birthDate: new Date('1992-03-18'),
        roles: ['PLAYER'],
        status: 'VALIDATED'
      },
      changedAt: new Date('2024-04-15T13:20:00Z'),
      changedByUserId: '550e8400-e29b-41d4-a716-446655440998',
      changedByUserName: 'Moreau Claire'
    }
  ];
}
