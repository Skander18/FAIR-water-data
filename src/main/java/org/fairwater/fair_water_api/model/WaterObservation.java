package org.fairwater.fair_water_api.model;

import org.eclipse.rdf4j.model.IRI;
import org.locationtech.jts.geom.Point;
import jakarta.persistence.*;

@Entity
@Table(name = "water_observations")
public class WaterObservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "geometry(Point,4326)")
    private Point location;

    private Double temperature;
    private Double pH;

    @Transient
    private IRI observationUri;

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getPH() {
        return pH;
    }

    public void setPH(Double pH) {
        this.pH = pH;
    }

    public IRI getObservationUri() {
        return observationUri;
    }

    public void setObservationUri(IRI observationUri) {
        this.observationUri = observationUri;
    }
}