package org.fairwater.fair_water_api.config;

import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.rdf4j.repository")
public class Rdf4jConfig {
    private String url;
    private String id;

    @Bean
    public Repository rdf4jRepository() {
        HTTPRepository repository = new HTTPRepository(url, id);
        repository.init();
        return repository;
    }

    // Getters et setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}