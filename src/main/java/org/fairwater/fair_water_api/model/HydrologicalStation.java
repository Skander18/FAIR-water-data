package org.fairwater.fair_water_api.model;

import org.eclipse.rdf4j.model.IRI;
import org.locationtech.jts.geom.Point;
import jakarta.persistence.*;

@Entity
@Table(name = "hydrological_stations")
public class HydrologicalStation {

    @Id
    private String stationId;

    @Column(columnDefinition = "geometry(Point,4326)")
    private Point location;

    private String name;

    @Transient
    private IRI sosaSensorUri;

    // Getters et setters
    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IRI getSosaSensorUri() {
        return sosaSensorUri;
    }

    public void setSosaSensorUri(IRI sosaSensorUri) {
        this.sosaSensorUri = sosaSensorUri;
    }
}