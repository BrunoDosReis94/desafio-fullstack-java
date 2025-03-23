import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; // Importe o HttpClientModule
import { ReactiveFormsModule } from '@angular/forms'; // Importe o ReactiveFormsModule
import { PoModule } from '@po-ui/ng-components'; // Importe o PoModule
import { PoTemplatesModule } from '@po-ui/ng-templates'; // Importe o PoTemplatesModule
import { RouterModule } from '@angular/router'; // Importe o RouterModule

import { AppRoutingModule } from './app-routing.module'; // Importe o AppRoutingModule
import { AppComponent } from './app.component';
import { PaisesComponent } from './paises/paises.component';
import { CadastroPaisesComponent } from './paises/cadastro-paises/cadastro-paises.component';
import { PontosTuristicosComponent } from './pontos-turisticos/pontos-turisticos.component';
import { CadastroPontosTuristicosComponent } from './pontos-turisticos/cadastro-pontos-turisticos/cadastro-pontos-turisticos.component';
import { ComentariosComponent } from './comentarios/comentarios.component';
import { CadastroComentarioComponent } from './comentarios/cadastro-comentario/cadastro-comentario.component';

@NgModule({
  declarations: [
    AppComponent,
    PaisesComponent,
    CadastroPaisesComponent,
    PontosTuristicosComponent,
    CadastroPontosTuristicosComponent,
    ComentariosComponent,
    CadastroComentarioComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule, // Adicione o HttpClientModule para requisições HTTP
    ReactiveFormsModule, // Adicione o ReactiveFormsModule para formulários reativos
    PoModule, // Adicione o PoModule para usar componentes do PO-UI
    PoTemplatesModule, // Adicione o PoTemplatesModule para templates do PO-UI
    RouterModule.forRoot([]), // Configure o RouterModule
    AppRoutingModule // Adicione o AppRoutingModule para gerenciar as rotas
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
