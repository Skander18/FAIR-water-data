package org.fairwater.fair_water_api.service;

import org.eclipse.rdf4j.query.*;
import org.eclipse.rdf4j.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SparqlService {

    @Autowired
    private Repository repository;

    public TupleQueryResult executeGeoQuery(String wktGeometry) {
        String query = """
                PREFIX geo: <http://www.opengis.net/ont/geosparql#>
                SELECT ?station WHERE {
                    ?station a <http://www.w3.org/ns/sosa/Sensor> ;
                           geo:hasGeometry ?geom .
                    FILTER(geof:sfWithin(?geom, \"%s\"^^geo:wktLiteral))
                }""".formatted(wktGeometry);

        try (var conn = repository.getConnection()) {
            TupleQuery tupleQuery = conn.prepareTupleQuery(query);
            return tupleQuery.evaluate();
        }
    }
}