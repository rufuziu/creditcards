package br.com.microservices.avaliador.application;

import br.com.microservices.avaliador.application.service.AvaliadorCreditoService;
import br.com.microservices.avaliador.domain.model.SituacaoCliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("avaliacoes-credito")
@Slf4j
public class AvaliadorController {

  private final AvaliadorCreditoService service;
  public AvaliadorController(AvaliadorCreditoService service){
    this.service = service;
  }

  @GetMapping
  public String status() {
    log.info("obtendo o status do microservice de clientes");
    return "ok";
  }

  @GetMapping(value="situacao-cliente",params = "cpf")
  public ResponseEntity<SituacaoCliente>
  consultaSituacaoCliente(@RequestParam("cpf") String cpf) {
    SituacaoCliente situacaoCliente =
          service.obterSituacaoCliente(cpf);
    return  ResponseEntity.ok(situacaoCliente);
  }
}
