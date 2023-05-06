package com.interthedungeon;

import javax.jms.ConnectionFactory;
import org.apache.qpid.jms.JmsConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionFactoryConfiguration {

    @Value("${remoteURI}")
    private String remoteURI;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean
    public ConnectionFactory connectionFactory() {
        JmsConnectionFactory connectionFactory = new JmsConnectionFactory();
        connectionFactory.setRemoteURI(remoteURI);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);

        String keyStoreLocation = "/etc/camel/resources/broker.ks";
        String trustStoreLocation = "/etc/camel/resources/client.ts";

        return connectionFactory;
    }
}
