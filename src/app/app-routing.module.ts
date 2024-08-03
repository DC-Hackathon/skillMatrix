import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductComponent } from './features/product/product.component';
import { SkillComponent } from './features/skill/skill.component';
import { UserSkillComponent } from './features/user-skill/user-skill.component';

export const routes: Routes = [
    {
        path: '',
        pathMatch: 'full',
        redirectTo: 'admin'
    },
    {
        path: 'admin',
        component: SkillComponent,
    },
    {
        path: 'user',
        component: UserSkillComponent,
    },
    {
        path: 'dashboard',
        component: ProductComponent,
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }