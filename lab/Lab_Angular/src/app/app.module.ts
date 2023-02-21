import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeSectionComponent } from './components/home-section/home-section.component';
import { ItemsSectionComponent } from './components/items-section/items-section.component';
import { StockSectionComponent } from './components/stock-section/stock-section.component';
import { WeatherSectionComponent } from './components/weather-section/weather-section.component';
import { VolunteersSectionComponent } from './components/volunteers-section/volunteers-section.component';
import { AboutSectionComponent } from './components/about-section/about-section.component';
import { ManpadTemplateComponent } from './components/manpad-template/manpad-template.component';
import { PutRequestFormComponent } from './components/request-form/put-request-form.component';
import { HttpClientModule } from '@angular/common/http';
import { MatFormFieldModule} from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';


import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from "@angular/material/button";
import { PostRequestComponent } from './components/post-request/post-request.component';
import { StockItemComponent } from './components/stock-item/stock-item.component';

@NgModule({
  declarations: [
    PutRequestFormComponent,
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeSectionComponent,
    ItemsSectionComponent,
    StockSectionComponent,
    WeatherSectionComponent,
    VolunteersSectionComponent,
    AboutSectionComponent,
    ManpadTemplateComponent,
    PostRequestComponent,
    StockItemComponent
  ],
  imports: [
    MatFormFieldModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatRadioModule,
    MatInputModule,
    MatButtonModule,
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
