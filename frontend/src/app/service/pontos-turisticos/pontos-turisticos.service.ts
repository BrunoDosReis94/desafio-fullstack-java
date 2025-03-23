import { Injectable } from '@angular/core';
import { HttpService } from '../http-service.service'; // Importe o HttpService
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PontosTuristicosService {
  private endpoint = 'pontos-turisticos'; // Endpoint da API para pontos turísticos

  constructor(private httpService: HttpService) { }

  // Cadastrar um novo ponto turístico
  cadastrarPontoTuristico(pontoTuristico: any): Observable<any> {
    return this.httpService.post(this.endpoint, pontoTuristico);
  }

  // Listar todos os pontos turísticos
  listarPontosTuristicos(): Observable<any> {
    return this.httpService.get(this.endpoint);
  }

  // Buscar um ponto turístico por ID
  buscarPontoTuristicoPorId(id: number): Observable<any> {
    return this.httpService.get(`${this.endpoint}/${id}`);
  }

  // Atualizar um ponto turístico
  atualizarPontoTuristico(id: number, pontoTuristico: any): Observable<any> {
    return this.httpService.put(`${this.endpoint}/${id}`, pontoTuristico);
  }

  // Excluir um ponto turístico
  excluirPontoTuristico(id: number): Observable<any> {
    return this.httpService.delete(`${this.endpoint}/${id}`);
  }
}
