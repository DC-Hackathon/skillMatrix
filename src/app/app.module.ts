import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import { CoreModule } from "./core/core.component.module";
import { BrowserModule } from "@angular/platform-browser";
import { FormGroup, FormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";
import { SidenavComponent } from "./core/components/sidenav/sidenav.component";
import { RouterModule } from "@angular/router";
import { MatButtonModule } from "@angular/material/button";
import { MatDividerModule } from "@angular/material/divider";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { MatSelectModule } from "@angular/material/select";
import { SkillComponent } from "./features/skill/skill.component";

@NgModule({
    declarations: [AppComponent, SkillComponent],
    imports: [
        CoreModule,
        BrowserModule,
        FormsModule,
        CommonModule,
        SidenavComponent,
        AppComponent,
        RouterModule,MatFormFieldModule, MatInputModule, 
        MatSelectModule, MatButtonModule,
        MatDividerModule, CommonModule
    ],
    exports:[],
    providers: [SkillComponent]
})
export class AppModule {};