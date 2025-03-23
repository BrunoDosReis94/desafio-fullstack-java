import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PoNotificationService } from '@po-ui/ng-components';
import { HttpService } from 'src/app/service/http-service.service';

@Component({
  selector: 'app-pontos-turisticos',
  templateUrl: './pontos-turisticos.component.html',
  styleUrls: ['./pontos-turisticos.component.css']
})
export class PontosTuristicosComponent implements OnInit {
  lsActions = [
    { action: this.editar.bind(this), label: 'Editar', icon: 'po-icon-edit' },
    { action: this.excluir.bind(this), label: 'Excluir', icon: 'po-icon-delete' }
  ];
  lsColumns = [
    { property: 'nome', label: 'Nome' },
    { property: 'cidade', label: 'Cidade' },
    { property: 'pais', label: 'País' },
    { property: 'melhorEstacao', label: 'Melhor Estação' }
  ];
  lsPontosTuristicos: any[] = [];

  constructor(
    private router: Router,
    private poNotification: PoNotificationService,
    private http: HttpService
  ) {}

  ngOnInit(): void {
    this.carregarPontosTuristicos();
  }

  navegarParaCadastro() {
    this.router.navigate(['/pontos-turisticos/novo']); // Corrigido para a rota de pontos turísticos
  }

  carregarPontosTuristicos() {
    this.http.get('pontos-turisticos').subscribe({
      next: (resposta) => {
        this.lsPontosTuristicos = resposta;
      },
      error: (erro) => {
        this.poNotification.error(erro);
      }
    });
  }

  editar(item: any) {
    this.router.navigate(['/pontos-turisticos/editar', item.id]); // Corrigido para a rota de pontos turísticos
  }

  excluir(item: any) {
    this.http.delete('pontos-turisticos/' + item.id).subscribe({
      next: () => {
        this.poNotification.success("Registro excluído com sucesso!");
        this.carregarPontosTuristicos();
      },
      error: (erro) => {
        this.poNotification.error(erro);
      }
    });
  }
}
