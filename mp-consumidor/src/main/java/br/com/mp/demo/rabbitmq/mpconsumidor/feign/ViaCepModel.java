package br.com.mp.demo.rabbitmq.mpconsumidor.feign;


import br.com.mp.demo.rabbitmq.mpconsumidor.model.Cep;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ViaCepModel {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;

    public Cep toModel() {
        return new Cep(cep, bairro, logradouro);
    }
}

