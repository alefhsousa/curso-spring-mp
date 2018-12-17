package br.com.mp.demo.rabbitmq.mpconsumidor.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viaCep")
public interface ViaCepClient {

    @GetMapping("{cep}/json")
    ViaCepModel consultaCep(@PathVariable("cep") String cep);
}
