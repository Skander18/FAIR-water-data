package org.fairwater.fair_water_api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.features")
public class FeatureFlagsConfig {
    private boolean rdf4jEnabled = true;
    private boolean ogcEnabled = true;

    // Getters et setters
    public boolean isRdf4jEnabled() {
        return rdf4jEnabled;
    }

    public void setRdf4jEnabled(boolean rdf4jEnabled) {
        this.rdf4jEnabled = rdf4jEnabled;
    }

    public boolean isOgcEnabled() {
        return ogcEnabled;
    }

    public void setOgcEnabled(boolean ogcEnabled) {
        this.ogcEnabled = ogcEnabled;
    }
}