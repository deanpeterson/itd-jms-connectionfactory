package com.interthedungeon;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import org.apache.qpid.jms.JmsConnectionFactory;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ConnectionFactoryConfiguration {

    @Inject
    @ConfigProperty(name = "remoteURI")
    private String remoteURI;

    @Inject
    @ConfigProperty(name = "username")
    private String username;

    @Inject
    @ConfigProperty(name = "password")
    private String password;

    @Produces
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
