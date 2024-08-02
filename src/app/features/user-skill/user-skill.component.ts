import { CommonModule } from '@angular/common';
import { Component, OnDestroy, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { ReplaySubject, takeUntil } from 'rxjs';
import { CategoryMasterDto, AddSkillRequest, CategoryControllerService, SkillControllerService, UserControllerService, UserDto, SkillMasterDto, ProductControllerService, ProductMasterDto, FunctionMasterDto, FunctionControllerService, UserSkillDto, UserSkillMappingControllerService, UserSkillRequest } from '../../generated/angular-client';
import { Router } from '@angular/router';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { UserSkillDetailsComponent } from './user-skill-details/user-skill-details.component';
import { Proficency } from '../../utils/enum/Proficency';
import { SkillService } from '../../skill.service';
import { log } from 'console';

@Component({
  selector: 'app-user-skill',
  standalone: true,
  animations: [
    trigger('detailExpand', [
      state('collapsed,void', style({ height: '0px', minHeight: '0' })),
      state('expanded', style({ height: '*' })),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
  imports: [
    MatFormFieldModule, MatInputModule,
    MatSelectModule, MatButtonModule,
    MatIconModule, MatSlideToggleModule,
    MatDividerModule, CommonModule,
    FormsModule, ReactiveFormsModule, MatTableModule,
    UserSkillDetailsComponent
  ],
  templateUrl: './user-skill.component.html',
  styleUrl: './user-skill.component.css'
})
export class UserSkillComponent implements OnInit, OnDestroy {

  private destroyed$: ReplaySubject<boolean> = new ReplaySubject(1);
  error: string = '';
  userMaster: UserDto[] = [];
  ELEMENT_DATA: CategoryMasterDto[] = [];
  USER_DATA: UserDto[] = []
  columnsToDisplay: string[] = ['name', 'designation', 'role', 'location', 'experience', 'managerName'];
  userColumnDisplayNames: { [key: string]: string } = {
    name: 'Name',
    designation: 'Designation',
    role: 'Role',
    location: 'Location',
    experience: 'Experience',
    managerName: 'Manager Name'
  };
  columnsToDisplayWithExpand = [...this.columnsToDisplay, 'expand'];
  expandedElement?: UserDto | null;
  userSkillDataSource = new MatTableDataSource<UserDto>(this.userMaster);
  skillForm!: FormGroup;
  addSkillReq!: AddSkillRequest;
  categoryMaster: Set<CategoryMasterDto> = new Set<CategoryMasterDto>();
  skillSet?: Set<SkillMasterDto>;
  productMasterDtos?: Array<ProductMasterDto> =[];
  checked = false;
  userSkillAdd?: UserSkillRequest;
  proficincy = Object.entries(Proficency).map(([key, value]) => ({ key, value }));

  constructor(private _categoryService: CategoryControllerService,
    private _userService: UserControllerService,
    private _functionService: FunctionControllerService,
    private _userSkillService: UserSkillMappingControllerService,
    private router: Router, private fb: FormBuilder, private skillService: SkillService) {
    this.skillForm = this.fb.group({
      userName: ['', Validators.required],
      category: ['', Validators.required],
      skill: ['', Validators.required],
      product: ['', Validators.required],
      profeciancyName: ['', Validators.required],
      certificate: ['', Validators.required],
      upSkill: ['', Validators.required]
    });
  }

  ngOnInit(): void {

    this._userService
      .getAllUser()
      .pipe(takeUntil(this.destroyed$))
      .subscribe({
        next: (data: Array<UserDto>) => {
          this.userMaster = data;
          this.userSkillDataSource.data = data
        },
        error: (error) => {
          console.log(error);
        },
        complete: () => {
          console.log("done");
        }
      })

    this._categoryService.getAllCategory().pipe(takeUntil(this.destroyed$)).subscribe({
      next: (data: Set<CategoryMasterDto>) => {
        this.categoryMaster = data;
        this.ELEMENT_DATA = Array.from(this.categoryMaster);
        // this.updateDataSource(this.ELEMENT_DATA);
      },
      error: (error: any) => {
        this.error = error;
      }
    });

    this._functionService
      .getAllFunction()
      .pipe(takeUntil(this.destroyed$))
      .subscribe({
        next: (data: Array<FunctionMasterDto>) => {
          if (data !== null) {
            data.forEach(f => {
              if(f.productMasterDtos?.length){
                f.productMasterDtos.forEach(p=> {
                  this.productMasterDtos?.push(p)
                })
              }
            })
          }
        }, error: (error) => {
          console.log(error);
        },
        complete: () => {
          console.log("finish");
        }
      });
  }

  onItemSelected(event: any) {
    console.log(event.value);

    this.ELEMENT_DATA.filter((f) => {
      if (f.categoryName === event.value) {
        this.skillSet = f.skillMasterSet!;
      }
    });
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

    if (this.skillForm.invalid) {
      this.skillForm.markAllAsTouched;
      return;
    }

    this.addSkill();
  }

  ngOnDestroy(): void {
    this.destroyed$.complete();
  }

  applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value;
    this.userSkillDataSource = new MatTableDataSource<UserDto>(this.userMaster);
    this.userSkillDataSource.filter = filterValue.trim().toLowerCase();
    if (filterValue !== '' && this.userSkillDataSource.filteredData.length === 0) {
      let data = this.userMaster.filter(user => user.userSkillDto?.some(some => {
        return this.getFilters(some,filterValue)
      }
      ));
      this.userSkillDataSource = new MatTableDataSource<UserDto>(data);
    }
  }
  getFilters(some: UserSkillDto, filterValue:string): boolean {
    return (some.skillId?.trim().toLowerCase() === filterValue.trim().toLowerCase() 
    || some.proficiencyLevel?.trim().toLowerCase() === filterValue.trim().toLowerCase()
    || some.productId?.trim().toLowerCase() === filterValue.trim().toLowerCase()
    || some.categoryId?.trim().toLowerCase() === filterValue.trim().toLowerCase()
    );
  }


  populateSkillDetailsOnExpand(element: UserDto) {

    this.skillService.setUserMasterData(element.userSkillDto!);
  }

}
