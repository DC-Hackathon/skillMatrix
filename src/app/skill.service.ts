import { Injectable } from '@angular/core';
import { UserSkillDto } from './generated/angular-client';
import { BehaviorSubject, Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SkillService {
  userMasterDataSubject$: BehaviorSubject<Array<UserSkillDto>> = new BehaviorSubject<Array<UserSkillDto>>([]);
  userMasterData$: Observable<Array<UserSkillDto>> = this.userMasterDataSubject$.asObservable();

  constructor() { }

  setUserMasterData(userMasterData: Array<UserSkillDto> ){
    this.userMasterDataSubject$.next(userMasterData);
  }
}
