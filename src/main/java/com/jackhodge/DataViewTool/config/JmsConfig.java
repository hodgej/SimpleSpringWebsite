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

/*
@Configuration
@EnableJms
public class JmsConfig {
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
            ConnectionFactory connecionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer
    ){


    }
}
*/