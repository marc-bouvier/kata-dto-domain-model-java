package dao;

import entities.ConceptEntity;
import entities.DefinitionEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class ConceptRepository {

    private final Set<ConceptEntity> concepts;

    public ConceptRepository(Set<ConceptEntity> concepts) {
        this.concepts = concepts;
    }


    public List<ConceptEntity> findAll() {
        // equivalent SQL : SELECT * ...
        return new ArrayList<>(concepts);
    }

    public List<DefinitionEntity> findAllDefinitionsByTag(String tag) {
        // Equivalent d'une requete sql avec des jointures et une clause where
        return concepts.stream()
                .flatMap(conceptEntity -> conceptEntity.definitions.stream())
                .filter(definitionEntity -> definitionEntity.tags.contains(tag))
                .collect(toList());
    }
}
