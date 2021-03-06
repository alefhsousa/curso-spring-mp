package br.com.mp.demo.rabbitmq.mpprodutor.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Autowired private ConnectionFactory connectionFactory;

    @Value(value = "${mensageria.topico.nome}")
    private String nomeTopico;
    @Value(value = "${mensageria.topico.nomeFila}")
    private String nomeFila;
    @Value(value = "${mensageria.topico.routingKey}")
    private String routingKey;

    @Bean
    public RabbitTemplate rabbitTemplate(MessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    public MessageConverter messageConverter () {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public Binding ligaTopicoComAFila(Queue filaDocumentos,
                                      TopicExchange documentosExchange) {

        return BindingBuilder.bind(filaDocumentos)
                .to(documentosExchange)
                .with(routingKey);
    }

    @Bean(name = "filaDocumentos")
    public Queue filaDocumentos() {
        return new Queue(nomeFila);
    }


    @Bean
    public TopicExchange documentosExchange() {
        return new TopicExchange(nomeTopico);
    }

}
