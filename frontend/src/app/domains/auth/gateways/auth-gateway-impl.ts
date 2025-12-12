import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '@environments/environment';
import {UserRegistration} from '@app/domains/auth/dtos/user-registration';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGatewayImpl {
  private readonly http = inject(HttpClient);
  public registerUser(userRegistration: UserRegistration): Observable<void> {
    return this.http.post<void>(`${environment.apiUrl}/auth/register`, userRegistration);
  }
}
