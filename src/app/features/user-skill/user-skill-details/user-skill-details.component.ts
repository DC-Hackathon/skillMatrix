import { Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';
import { UserSkillDto } from '../../../generated/angular-client';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { SkillService } from '../../../skill.service';
import { Observable, ReplaySubject, takeUntil } from 'rxjs';

@Component({
  selector: 'app-user-skill-details',
  standalone: true,
  imports: [MatFormFieldModule,
    MatSelectModule, MatButtonModule,
    MatIconModule, MatSlideToggleModule,
    MatDividerModule, CommonModule,
    FormsModule, ReactiveFormsModule, MatTableModule
  ],
  templateUrl: './user-skill-details.component.html',
  styleUrl: './user-skill-details.component.css'
})
export class UserSkillDetailsComponent implements OnInit, OnDestroy {
  // @Input() userDetail?: Array<UserSkillDto>;

  private destroyed$: ReplaySubject<boolean> = new ReplaySubject(1);
  displayColums: string[] = ['categoryId', 'skillId', 'productId', 
    'proficiencyLevel', 'certificateDone', 'upSkill'
  ];
  userColumnDisplayNames: { [key: string]: string } = {
    categoryId: 'Category',
    skillId: 'Skill',
    productId: 'Product',
    proficiencyLevel: 'Proficiency',
    certificateDone: 'Certification',
    upSkill: 'Up Skill'
  };
  // dataSource = new MatTableDataSource<UserSkillDto>(this.userMasterData);
  columnsToDisplayWithExpand = [...this.displayColums];
  userMasterData: Array<UserSkillDto> = new Array<UserSkillDto>();
  
  constructor(private skillService: SkillService) {}

  ngOnInit(): void { 
      this.skillService.userMasterData$
      .pipe(takeUntil(this.destroyed$))
      .subscribe((data)=> {
        this.userMasterData = data;
        console.log(this.userMasterData);
        
      })
  }

  ngOnDestroy(): void {
    this.destroyed$.complete();
  }


}
