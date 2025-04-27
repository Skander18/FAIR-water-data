package org.fairwater.fair_water_api.config;

import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import java.io.IOException;
import java.util.Properties;

public class YamlPropertySourceFactory implements PropertySourceFactory {
    @Override
    @NonNull
    public PropertySource<?> createPropertySource(
            @Nullable String name,
            @NonNull EncodedResource resource) throws IOException {

        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());
        Properties properties = factory.getObject();

        if (properties == null) {
            throw new IllegalStateException("Failed to load YAML properties");
        }

        String sourceName = name != null ? name : resource.getResource().getFilename();
        if (sourceName == null) {
            sourceName = "unknown";
        }

        return new PropertiesPropertySource(sourceName, properties);
    }
}