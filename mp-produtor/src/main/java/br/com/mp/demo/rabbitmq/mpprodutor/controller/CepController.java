package br.com.mp.demo.rabbitmq.mpprodutor.controller;


import br.com.mp.demo.rabbitmq.mpprodutor.controller.dto.CepInput;
import br.com.mp.demo.rabbitmq.mpprodutor.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/cep")
public class CepController {

    @Autowired private CepService service;

    @PostMapping
    public ResponseEntity consultaCep(@RequestBody CepInput cepInput) {

        service.consultaCep(cepInput);
        return ResponseEntity.accepted().build();
    }
}
