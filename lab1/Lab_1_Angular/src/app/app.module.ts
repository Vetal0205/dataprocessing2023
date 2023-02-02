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
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeSectionComponent,
    ItemsSectionComponent,
    StockSectionComponent,
    WeatherSectionComponent,
    VolunteersSectionComponent,
    AboutSectionComponent,
    ManpadTemplateComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
