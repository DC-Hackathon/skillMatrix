import { NgModule } from "@angular/core";
import { HeaderComponent } from "./components/header/header.component";
import { AppComponent } from "../app.component";

@NgModule({
    declarations: [HeaderComponent],
    imports: [],
    exports:[HeaderComponent],
    providers: [],
    bootstrap: [AppComponent]

})
export class CoreModule{}
