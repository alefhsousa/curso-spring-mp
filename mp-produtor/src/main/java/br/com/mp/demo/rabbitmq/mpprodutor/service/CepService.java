package br.com.mp.demo.rabbitmq.mpprodutor.service;


import br.com.mp.demo.rabbitmq.mpprodutor.controller.dto.CepInput;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.RandomAccess;

@Service
public class CepService {

    @Autowired private RabbitTemplate rabbitTemplate;

    @Value(value = "${mensageria.topico.nome}")
    private String nomeTopico;
    @Value(value = "${mensageria.topico.routingKey}")
    private String routingKey;

    public void consultaCep(CepInput cepInput) {
            rabbitTemplate.convertAndSend(nomeTopico, routingKey, cepInput);

    }
}
