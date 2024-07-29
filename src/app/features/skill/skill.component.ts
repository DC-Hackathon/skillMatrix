import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { AddSkillRequest, CategoryControllerService, CategoryMasterDto, SkillControllerService, SkillMasterDto } from '../../generated/angular-client';
import { ReplaySubject } from 'rxjs';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormGroup, FormsModule, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-skill',
  standalone: true,
  imports: [
    MatFormFieldModule, MatInputModule,
    MatSelectModule, MatButtonModule,
    MatIconModule,
    MatDividerModule, CommonModule,
    FormsModule, ReactiveFormsModule, MatTableModule
  ],
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css']
})
export class SkillComponent implements OnInit, OnDestroy {

  private destroyed$: ReplaySubject<boolean> = new ReplaySubject(1);
  error: string = '';
  categoryMaster: Set<CategoryMasterDto> = new Set<CategoryMasterDto>();
  ELEMENT_DATA: CategoryMasterDto[] = [];
  displayedColumns: string[] = ['categoryName', 'skillMasterSet'];
  dataSource = new MatTableDataSource<CategoryMasterDto>(this.ELEMENT_DATA);
  skillForm: FormGroup;
  addSkillReq!: AddSkillRequest;

  constructor(private _categoryService: CategoryControllerService,
              private _skillService: SkillControllerService,
              private router: Router, private fb: FormBuilder) {
    this.skillForm = this.fb.group({
      category: ['', Validators.required],
      skillName: ['', [Validators.required, Validators.maxLength(50)]]
    });
  }

  ngOnInit(): void {
    this.dataSource.filterPredicate = this.createFilter();
    
    this._categoryService.getAllCategory().subscribe({
      next: (data: Set<CategoryMasterDto>) => {
        this.categoryMaster = data;
        this.ELEMENT_DATA = Array.from(this.categoryMaster);
        this.updateDataSource(this.ELEMENT_DATA);
      },
      error: (error: any) => {
        this.error = error;
      }
    });
  }

  updateDataSource(categoryDto: CategoryMasterDto[]){
    return this.dataSource.data = this.ELEMENT_DATA;
  }

  addSkill(): void {
    this.addSkillReq = {
      skillName: this.skillForm.get('skillName')?.value,
      categoryId: this.skillForm.get('category')?.value
    };

    this._skillService.addSkill(this.addSkillReq).subscribe({
      next: () => {
        this.ngOnInit();
        this.reloadComponent();
      },
      error: (error: any) => {
        this.error = error;
        this.reloadComponent();
      }
    });
  }

  onSubmit(): void {
    if (this.skillForm.invalid) {
      this.skillForm.markAllAsTouched();
      return;
    }

    this.addSkill();
    this.skillForm.reset();
    this.reloadComponent();
  }

  ngOnDestroy(): void {
    this.destroyed$.complete();
  }

  private reloadComponent(): void {
    const currentUrl = this.router.url;
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate([currentUrl]);
    });
  }

  applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  createFilter(): (data: CategoryMasterDto, filter: string) => boolean {
    return (data: CategoryMasterDto, filter: string): boolean => {
      const transformedFilter = filter.trim().toLowerCase();
      const matchCategoryName = data.categoryName?.toLowerCase().includes(transformedFilter) || false;
      const matchSkillName = data.skillMasterSet ? Array.from(data.skillMasterSet).some(skill => skill.skill?.toLowerCase().includes(transformedFilter) || false) : false;
      return matchCategoryName || matchSkillName;
    };
  }
}
