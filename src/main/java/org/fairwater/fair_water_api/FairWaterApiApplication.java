
package org.fairwater.fair_water_api;

import org.fairwater.fair_water_api.config.OgcConfig;
import org.fairwater.fair_water_api.config.Rdf4jConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ Rdf4jConfig.class, OgcConfig.class })
public class FairWaterApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(FairWaterApiApplication.class, args);
	}
}