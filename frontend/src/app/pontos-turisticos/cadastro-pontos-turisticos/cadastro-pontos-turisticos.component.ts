import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PoNotificationService } from '@po-ui/ng-components';

@Component({
  selector: 'app-cadastro-pontos-turisticos',
  templateUrl: './cadastro-pontos-turisticos.component.html',
  styleUrls: ['./cadastro-pontos-turisticos.component.css']
})
export class CadastroPontosTuristicosComponent implements OnInit {
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
  lsPontosTuristicos: any[] = [
    {
      id: 1,
      nome: 'Cristo Redentor',
      cidade: 'Rio de Janeiro',
      pais: 'Brasil',
      melhorEstacao: 'VERAO'
    },
    {
      id: 2,
      nome: 'Torre Eiffel',
      cidade: 'Paris',
      pais: 'França',
      melhorEstacao: 'PRIMAVERA'
    },
    {
      id: 3,
      nome: 'Grand Canyon',
      cidade: 'Arizona',
      pais: 'Estados Unidos',
      melhorEstacao: 'OUTONO'
    }
  ];

  constructor(
    private router: Router,
    private poNotification: PoNotificationService
  ) {}

  ngOnInit(): void {
    // Não é necessário carregar dados do backend agora
  }

  navegarParaCadastro() {
    this.router.navigate(['/pontos-turisticos/novo']);
  }

  editar(item: any) {
    this.router.navigate(['/pontos-turisticos/editar', item.id]);
  }

  excluir(item: any) {
    // Remove o item da lista mockada
    this.lsPontosTuristicos = this.lsPontosTuristicos.filter(ponto => ponto.id !== item.id);
    this.poNotification.success("Registro excluído com sucesso!");
  }
}
