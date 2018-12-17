package br.com.mp.demo.rabbitmq.mpconsumidor.repository;


import br.com.mp.demo.rabbitmq.mpconsumidor.model.Cep;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CepRepository extends
        MongoRepository<Cep, String> {
}
