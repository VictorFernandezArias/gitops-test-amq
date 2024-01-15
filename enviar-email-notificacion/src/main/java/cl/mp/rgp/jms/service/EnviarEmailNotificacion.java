package cl.mp.rgp.jms.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


import cl.mp.rgp.jms.model.Persona;

@Component
public class EnviarEmailNotificacion {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnviarEmailNotificacion.class);
    private final JmsTemplate jmsTemplate;


    @Value("${queue.to.name}")
    private String queueToName;

    public EnviarEmailNotificacion(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void notificarPersona(Persona persona) {
        LOGGER.info("Notifing to {} to Email {}", persona.getName(), persona.getEmail());
        persona.setNotified(true);
        LOGGER.info("{} Notified", persona.getName());

        LOGGER.info("Publishing persona {} to destination {}", persona, this.queueToName);
        this.jmsTemplate.convertAndSend(this.queueToName, persona);
    }


    @JmsListener(destination = "${queue.from.name}")
    public void receiveMessage(Persona persona) {
        LOGGER.info("Received: {}", persona);
        notificarPersona(persona);
    }

}
