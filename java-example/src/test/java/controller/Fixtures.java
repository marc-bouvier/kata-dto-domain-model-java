package controller;

import dao.InMemoryConceptRepository;
import entities.ConceptEntity;
import entities.DefinitionEntity;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Fixtures {
    public static InMemoryConceptRepository getConceptRepository() {
        return new InMemoryConceptRepository(
                Set.of(
                        new ConceptEntity(
                                new Date(),
                                List.of(
                                        new DefinitionEntity(
                                                "DTO",
                                                "Intermédiaire pour découpler des données entre plusieurs systèmes",
                                                Set.of("Java", "Design Pattern", "Web")
                                        ),
                                        new DefinitionEntity(
                                                "Serializable",
                                                "Permet de transformer un objet en text (ex. JSON)",
                                                Set.of("Java")
                                        ),
                                        new DefinitionEntity(
                                                "Payload",
                                                "Corps d'une requête / réponse",
                                                Set.of("Web")

                                        )
                                )
                        )));
    }
}
