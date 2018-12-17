package br.com.mp.demo.rabbitmq.mpconsumidor;

import br.com.mp.demo.rabbitmq.mpconsumidor.feign.ViaCepClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = {ViaCepClient.class})
public class MpConsumidorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpConsumidorApplication.class, args);
	}

}

