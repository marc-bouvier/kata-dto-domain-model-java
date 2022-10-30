package controller;

import dao.ConceptRepository;
import entities.ConceptEntity;
import entities.DefinitionEntity;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class EntityConceptControllerTest {

    @Test
    void test() {

        // Arrange (Given)
        EntityConceptController controller = setup();


        // Act (When)
        List<ConceptEntity> all = controller.all();


        // Assert (Then)
        assertThat(all).hasSize(1);

        ConceptEntity first = all.get(0);
        assertThat(first.definitions).hasSize(3);

    }

    @Test
    void test2() {

        // Arrange (Given)
        EntityConceptController controller = setup();


        // Act (When)
        List<DefinitionEntity> definitions = controller.findDefinitionsByTag("Java");


        // Assert (Then)
        assertThat(definitions).hasSize(2);
        DefinitionEntity first = definitions.get(0);

        assertThat(first.name).isNotNull();
        assertThat(first.contenu).isNull();
        assertThat(first.tags).isNull();

    }



    @Test
    void test3() {

        // Arrange (Given)
        EntityConceptController controller = setup();

        // Act (When)
        controller.findDefinitionsByTag("Java");
        List<ConceptEntity> concepts = controller.all();
        List<DefinitionEntity> definitions = concepts.get(0).definitions;

        // Assert (Then)
        assertThat(definitions).hasSize(3);
        DefinitionEntity first = definitions.get(0);

        assertThat(first.name).isNotNull();
        assertThat(first.contenu).isNotNull();
        assertThat(first.tags).isNotNull();

    }



    private static EntityConceptController setup() {
        return new EntityConceptController(
                new ConceptRepository(
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
                                ))));
    }

}