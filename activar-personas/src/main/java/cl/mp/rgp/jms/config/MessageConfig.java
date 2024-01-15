package cl.mp.rgp.jms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/* import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.messaging.converter.MessageConversionException;
 */
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@Component
public class MessageConfig {
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");


        return converter;
    }

/* 

//si se quiere  customizar el converter
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
   
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter() {
           


            @Override
            public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
                TextMessage message = (TextMessage) super.toMessage(object, session);
                System.out.println("outbound json: " + message.getText());
                return message;
            }

            @Override
            public Object fromMessage(Message message) throws JMSException, MessageConversionException {
                System.out.println("inbound json: " + ((TextMessage) message).getText());
                return super.fromMessage(message);
            }

        };
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    } */
}
