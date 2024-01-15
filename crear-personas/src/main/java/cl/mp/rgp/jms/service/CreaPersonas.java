package cl.mp.rgp.jms.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cl.mp.rgp.jms.config.MessageConfig;
import cl.mp.rgp.jms.model.Persona;

@Component
public class CreaPersonas {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreaPersonas.class);
    private final JmsTemplate jmsTemplate;

    @Value("${queue.name}")
    private String queueName;

    public CreaPersonas(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
        //TODO: revisar esta lineqa que se suponer que debiese ser automatico
        this.jmsTemplate.setMessageConverter(new MessageConfig().jacksonJmsMessageConverter());
    }

    @Scheduled(fixedRate = 3000L)
    public void sendTick() {
        Persona persona = new Persona();
        LOGGER.info("Publishing fruit {} to destination {}", persona, this.queueName);
        this.jmsTemplate.convertAndSend(this.queueName, persona);
    }

}
