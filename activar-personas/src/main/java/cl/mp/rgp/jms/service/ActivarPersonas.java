package cl.mp.rgp.jms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


import cl.mp.rgp.jms.model.Persona;

@Component
public class ActivarPersonas {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivarPersonas.class);
    private final JmsTemplate jmsTemplate;


    @Value("${queue.to.name}")
    private String queueToName;

    public ActivarPersonas(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void activarPersona(Persona persona) {
        LOGGER.info("Activating {} ", persona.getName());
        persona.setActive(true);
        LOGGER.info("{} Activated", persona.getName());

        LOGGER.info("Publishing persona {} to destination {}", persona, this.queueToName);
        this.jmsTemplate.convertAndSend(this.queueToName, persona);
    }


    @JmsListener(destination = "${queue.from.name}")
    public void receiveMessage(Persona persona) {
        LOGGER.info("Received: {}", persona);
        activarPersona(persona);
    }

}
