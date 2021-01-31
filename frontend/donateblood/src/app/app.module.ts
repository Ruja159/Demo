import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {HttpClientModule} from '@angular/common/http'
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FooterComponent } from './footer/footer.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { JwtClientService } from './jwt-client.service';
import { AuthGuard } from './auth/auth.guard';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './material.module'; 
import { FlexLayoutModule } from '@angular/flex-layout';
import { CardComponent } from './card/card.component';
import { HeaderComponent } from './header/header.component';
import { TableComponent } from './table/table.component';
import { Card2Component } from './card2/card2.component';
import { Card3Component } from './card3/card3.component';
import { AddyourbloodytpeComponent } from './addyourbloodytpe/addyourbloodytpe.component';
import { AboutusComponent } from './aboutus/aboutus.component';

@NgModule({

  declarations: [
    AppComponent, 
    LoginComponent,
    routingComponents, 
    FooterComponent, CardComponent, HeaderComponent, TableComponent, Card2Component, Card3Component, AddyourbloodytpeComponent, AboutusComponent,
  ],
  imports: [
    BrowserModule, 
    AppRoutingModule, 
    NgbModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    FlexLayoutModule

  ],
  providers: [JwtClientService,AuthGuard],
  bootstrap: [AppComponent],
})
export class AppModule {}
