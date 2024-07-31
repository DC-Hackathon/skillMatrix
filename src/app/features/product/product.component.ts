import { CommonModule } from '@angular/common';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Router } from '@angular/router';
import { ReplaySubject, takeUntil } from 'rxjs';
import { FunctionControllerService, FunctionMasterDto, ProductControllerService, ProductMasterDto, ProductRequest } from '../../generated/angular-client';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [
    MatFormFieldModule, MatInputModule,
    MatSelectModule, MatButtonModule,
    MatIconModule,
    MatDividerModule, CommonModule,
    FormsModule, ReactiveFormsModule, MatTableModule
  ],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit, OnDestroy {
  private destroyed$: ReplaySubject<boolean> = new ReplaySubject(1);
  error: string = '';
  categoryMaster: [] = [];
  ELEMENT_DATA: FunctionMasterDto[] = [];
  displayedColumns: string[] = ['functionName', 'productMasterDtos', 'provider'];
  dataSource = new MatTableDataSource<FunctionMasterDto>(this.ELEMENT_DATA);
  productForm!: FormGroup;
  addProductReq!: ProductRequest;

  constructor(private _functionService: FunctionControllerService,
              private _productService: ProductControllerService,
              private router: Router, private fb: FormBuilder) {
    this.productForm = this.fb.group({
      functionName: ['', Validators.required],
      productName: ['', [Validators.required, Validators.maxLength(50)]],
      providerName: ['', [Validators.required, Validators.maxLength(50)]]
    });
  }

  ngOnInit(): void {
    this.dataSource.filterPredicate = this.createFilter();
    
    this._functionService
      .getAllFunction()
      .pipe(takeUntil(this.destroyed$))
      .subscribe({
        next: (data: Array<FunctionMasterDto>) => {
          this.ELEMENT_DATA = data;
          this.updateDataSource(this.ELEMENT_DATA);
        },
        error: (error) => {
          console.log(error);
          
        },
        complete: () => {
          this.ngOnDestroy();
        }
      
    })
  }

  updateDataSource(categoryDto: FunctionMasterDto[]){
    return this.dataSource.data = this.ELEMENT_DATA;
  }

  addSkill(): void {
    this.addProductReq = {
      functionId: this.productForm.get('functionName')?.value,
      productName: this.productForm.get('productName')?.value,
      provider: this.productForm.get('providerName')?.value
    };

    this._productService.saveProduct(this.addProductReq)
    .subscribe({
      next: () => {
        this.ngOnInit();
        this.reloadComponent();
      },
      error: (error) => {
        this.error = error;
        this.reloadComponent();
      }
    });
  }

  onSubmit(): void {
    if (this.productForm.invalid) {
      this.productForm.markAllAsTouched();
      return;
    }

    this.addSkill();
    this.productForm.reset();
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

  createFilter(): (data: FunctionMasterDto, filter: string) => boolean {
    return (data: FunctionMasterDto, filter: string): boolean => {
      const transformedFilter = filter.trim().toLowerCase();
      const matchCategoryName = data.functionName?.toLowerCase().includes(transformedFilter) || false;
      const matchProductName = data.productMasterDtos ?
          Array.from(data.productMasterDtos)
          .some(skill => skill.productName?.toLowerCase()
            .includes(transformedFilter) || false) : false;
      const matchProviderName = data.productMasterDtos ?
          Array.from(data.productMasterDtos)
          .some(skill => skill.provider?.toLowerCase()
            .includes(transformedFilter) || false) : false;
      return matchCategoryName || matchProductName || matchProviderName;
    };
  }

}
