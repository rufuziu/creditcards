package br.com.microservices.avaliador.application.service;

import br.com.microservices.avaliador.domain.model.DadosCliente;
import br.com.microservices.avaliador.domain.model.SituacaoCliente;
import br.com.microservices.avaliador.infra.clients.ClienteResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {
  private final ClienteResourceClient clienteResourceClient;

  public SituacaoCliente obterSituacaoCliente(String cpf) {
    ResponseEntity<DadosCliente> dadosClienteResponse =
            clienteResourceClient.dadosCliente(cpf);

    return SituacaoCliente
            .builder()
            .cliente(dadosClienteResponse.getBody())
            .build();
  }
}
