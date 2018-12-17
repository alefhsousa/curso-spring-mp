package br.com.mp.demo.rabbitmq.mpconsumidor.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ceps")
public class Cep {

    @Id
    private String id;

    private String cep;
    private String bairro;
    private String logradouro;

    public Cep(String cep, String bairro, String logradouro) {
        this.cep = cep;
        this.bairro = bairro;
        this.logradouro = logradouro;
    }

    public Cep() {
    }
}
