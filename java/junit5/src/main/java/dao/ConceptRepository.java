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

        List<DefinitionEntity> result = new ArrayList<>();

        for (ConceptEntity concept : concepts) {
            for (DefinitionEntity definition : concept.definitions) {
                if(definition.tags.contains(tag)){
                    result.add(definition);
                }
            }
        }

        return result;
    }
}
