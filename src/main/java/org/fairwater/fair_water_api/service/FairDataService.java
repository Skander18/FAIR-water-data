package org.fairwater.fair_water_api.service;

import org.fairwater.fair_water_api.model.WaterObservation;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FairDataService {

    @Autowired
    private Repository repository;

    public void convertToRdf(WaterObservation observation) {
        ValueFactory vf = repository.getValueFactory();
        IRI obs = vf.createIRI("http://data.fairwater.org/obs/" + observation.getId());

        try (RepositoryConnection conn = repository.getConnection()) {
            conn.add(obs, RDF.TYPE, vf.createIRI("http://www.w3.org/ns/sosa/Observation"));
            conn.add(obs,
                    vf.createIRI("http://www.w3.org/ns/sosa/hasResult"),
                    vf.createLiteral(observation.getTemperature()));
        }
    }
}