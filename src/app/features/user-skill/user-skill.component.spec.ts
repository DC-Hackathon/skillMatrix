import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserSkillComponent } from './user-skill.component';

describe('UserSkillComponent', () => {
  let component: UserSkillComponent;
  let fixture: ComponentFixture<UserSkillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserSkillComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UserSkillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
