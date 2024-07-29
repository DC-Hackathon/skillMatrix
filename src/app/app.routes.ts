import { Routes } from '@angular/router';
import { SkillComponent } from './features/skill/skill.component';
import { UserSkillComponent } from './features/user-skill/user-skill.component';
import { ProductComponent } from './features/product/product.component';

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
