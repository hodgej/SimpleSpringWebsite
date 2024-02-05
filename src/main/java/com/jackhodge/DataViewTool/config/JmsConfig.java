package com.jackhodge.DataViewTool.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;
import org.springframework.validation.ObjectError;


@Configuration
@EnableJms
public class JmsConfig {
    Logger logger = LoggerFactory.getLogger(JmsConfig.class);

    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
            ConnectionFactory connecionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer
    ){
        DefaultJmsListenerContainerFactory listenerContainerFactory = new DefaultJmsListenerContainerFactory();
        listenerContainerFactory.setConnectionFactory(connecionFactory);
        listenerContainerFactory.setConcurrency("1");
        listenerContainerFactory.setErrorHandler(
                t -> {logger.error("Listener Error: ", t);
                });
        listenerContainerFactory.setMessageConverter(this.jacksonJmsMessageConverter());

        return listenerContainerFactory;

    } 

    @Bean
    public MessageConverter jacksonJmsMessageConverter(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        converter.setObjectMapper(new ObjectMapper());
        return converter;
    }



    @Service
    public class JMSErrorHandler implements ErrorHandler {
        @Override
        public void handleError(Throwable t){
            logger.error("Error in listener ", t);
        }
    }


}
