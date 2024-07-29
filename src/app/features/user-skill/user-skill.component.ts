import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { ReplaySubject } from 'rxjs';
import { CategoryMasterDto, AddSkillRequest, CategoryControllerService, SkillControllerService, UserControllerService, UserDto, SkillMasterDto, ProductControllerService, ProductMasterDto, FunctionMasterDto, FunctionControllerService, UserSkillDto, UserSkillMappingControllerService } from '../../generated/angular-client';
import { Router } from '@angular/router';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';

@Component({
  selector: 'app-user-skill',
  standalone: true,
  imports: [
    MatFormFieldModule, MatInputModule,
    MatSelectModule, MatButtonModule,
    MatIconModule, MatSlideToggleModule,
    MatDividerModule, CommonModule,
    FormsModule, ReactiveFormsModule, MatTableModule
  ],
  templateUrl: './user-skill.component.html',
  styleUrl: './user-skill.component.css'
})
export class UserSkillComponent {

  private destroyed$: ReplaySubject<boolean> = new ReplaySubject(1);
  error: string = '';
  userMaster: Array<UserDto> = new Array<UserDto>();
  ELEMENT_DATA: CategoryMasterDto[] = [];
  FUNCTION_DATA:[] = [];
  displayedColumns: string[] = ['categoryName', 'skillMasterSet'];
  dataSource = new MatTableDataSource<CategoryMasterDto>(this.ELEMENT_DATA);
  skillForm!: FormGroup;
  addSkillReq!: AddSkillRequest;
  categoryMaster: Set<CategoryMasterDto> = new Set<CategoryMasterDto>();
  skillSet!: Set<SkillMasterDto>;
  productMasterDtos?: Array<ProductMasterDto>;
  checked = false;
  userSkillAdd?: UserSkillDto;

  
  constructor(private _categoryService: CategoryControllerService,
    private _userService: UserControllerService, 
    private _functionService: FunctionControllerService,
    private _userSkillService: UserSkillMappingControllerService,
    private router: Router, private fb: FormBuilder) {
      this.skillForm = this.fb.group({
        userName: ['', Validators.required],
        category:['', Validators.required],
        skill: ['', Validators.required],
        product: ['', Validators.required],
        profeciancyName: ['', Validators.required],
        certificate: ['', Validators.required],
        upSkill: ['', Validators.required]
      });
  }

  ngOnInit(): void {
    // this.dataSource.filterPredicate = this.createFilter();
    this._userService
      .getAllUser()
      .subscribe({
        next: (data: Array<UserDto>) => {
          this.userMaster = data;
          console.log(this.userMaster);
        },
        error: (error) => {
          console.log(error);
          
        },
        complete: () => {
          console.log("done");
        }
      })
    
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

    this._functionService
      .getAllFunction()
      .subscribe({
        next: (data: Array<FunctionMasterDto>) => {
          console.log(data);
          if(data !== null){
            data.forEach(f => {
              this.productMasterDtos = f.productMasterDtos;
            })
          }
        }, error: (error) => {
          console.log(error);
        },
        complete: () => {
          console.log("finish");
        }
      })
  }

  updateDataSource(categoryDto: CategoryMasterDto[]){
    return this.dataSource.data = this.ELEMENT_DATA;
  }

  onItemSelected(event:any) {
    console.log(event);
    this.ELEMENT_DATA.filter((f) => {
      if(f.id === event.value) {
        this.skillSet = f.skillMasterSet!;
      }
    })
  }

  addSkill(): void {
    this.userSkillAdd = {
      userId: this.skillForm.get('userName')?.value,
      categoryId: this.skillForm.get('category')?.value,
      skillId: this.skillForm.get('skill')?.value,
      productId: this.skillForm.get('product')?.value,
      proficiencyLevel: this.skillForm.get('profeciancyName')?.value,
      certificateDone: this.skillForm.get('certificate')?.value,  
      upSkill: this.skillForm.get('upSkill')?.value
    };

    console.log(this.userSkillAdd);
    this._userSkillService.mapUser(this.userSkillAdd)
      .subscribe({
        next: () => {
          this.ngOnInit();
          this.reloadComponent();
        }
      })
    
  }

  private reloadComponent(): void {
    const currentUrl = this.router.url;
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate([currentUrl]);
    });
  }

  onSubmit() {
    
    if(this.skillForm.invalid){
      this.skillForm.markAllAsTouched;
      return;
    }

    this.addSkill();
  }

  ngOnDestroy(): void {
    this.destroyed$.complete();
  }

}
