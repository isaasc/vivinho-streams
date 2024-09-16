package com.vivo.vivinho_streams.config;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CassandraConfig {

    @Bean
    @Primary
    public CqlSession cassandraSession() {
        DriverConfigLoader loader = DriverConfigLoader.fromClasspath("keyspaces-application.conf");
        return CqlSession.builder()
                .withConfigLoader(loader)
                .withKeyspace("vivinho_users_keyspace")
                .build();
    }
}

