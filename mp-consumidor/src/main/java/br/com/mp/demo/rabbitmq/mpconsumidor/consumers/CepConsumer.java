package br.com.mp.demo.rabbitmq.mpconsumidor.consumers;


import br.com.mp.demo.rabbitmq.mpconsumidor.feign.ViaCepClient;
import br.com.mp.demo.rabbitmq.mpconsumidor.feign.ViaCepModel;
import br.com.mp.demo.rabbitmq.mpconsumidor.model.Cep;
import br.com.mp.demo.rabbitmq.mpconsumidor.repository.CepRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class CepConsumer {

    private ViaCepClient viaCepClient;
    private CepRepository cepRepository;

    @RabbitListener(queues = "filaDocumentos")
    public void consomeMensagem(Cep cep) {
        log.info("recebendo a mensagem {} ", cep);
        ViaCepModel viaCepModel = viaCepClient.consultaCep(cep.getCep());

        log.info("endereco completo {} ", viaCepModel);

        cepRepository.save(viaCepModel.toModel());
    }
}
