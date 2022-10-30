package controller;

import dao.ConceptRepository;
import dto.ConceptResponseDto;
import dto.DefinitionsByTagResponseDto;
import entities.ConceptEntity;
import entities.DefinitionEntity;
import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class EntityDtoConceptControllerTest {

    @Test
    void test() {

        // Arrange (Given)
        EntityDtoConceptController controller = setup();


        // Act (When)
        List<ConceptResponseDto> all = controller.all();


        // Assert (Then)
        assertThat(all).hasSize(1);

        ConceptResponseDto first = all.get(0);
        assertThat(first.definitions).hasSize(3);

    }

    @Test
    void test2() {

        // Arrange (Given)
        EntityDtoConceptController controller = setup();


        // Act (When)
        DefinitionsByTagResponseDto definitionsByTag = controller.findDefinitionsByTag("Java");


        // Assert (Then)
        assertThat(definitionsByTag.definitions).hasSize(2);
        String first = definitionsByTag.definitions.get(0);

        assertThat(first).isNotNull();

    }



    @Test
    void test3() {

        // Arrange (Given)
        EntityDtoConceptController controller = setup();

        // Act (When)
        DefinitionsByTagResponseDto definitionsByTag = controller.findDefinitionsByTag("Java");
        List<ConceptResponseDto> concepts = controller.all();

        List<ConceptResponseDto.DefinitionDto> definitions = concepts.get(0).definitions;

        // Assert (Then)
        ListAssert<ConceptResponseDto.DefinitionDto> result = assertThat(definitions).hasSize(3);

        ConceptResponseDto.DefinitionDto first = definitions.get(0);

        assertThat(first.name).isNotNull();
        assertThat(first.contenu).isNotNull();
        assertThat(first.tags).isNotNull();

        assertThat(definitions).hasSize(3);

        assertThat(definitionsByTag.definitions).hasSize(2);


    }



    private static EntityDtoConceptController setup() {
        return new EntityDtoConceptController(
                new ConceptRepository(
                        Set.of(
                                new ConceptEntity(
                                        new Date(),
                                        List.of(
                                                new DefinitionEntity(
                                                        "DTO",
                                                        "Intermédiaire pour découpler des données entre plusieurs systèmes",
                                                        new HashSet<>(Set.of("Java", "Design Pattern", "Web"))
                                                ),
                                                new DefinitionEntity(
                                                        "Serializable",
                                                        "Permet de transformer un objet en text (ex. JSON)",
                                                        new HashSet<>(Set.of("Java"))
                                                ),
                                                new DefinitionEntity(
                                                        "Payload",
                                                        "Corps d'une requête / réponse",
                                                        new HashSet<>(Set.of("Web"))

                                                )
                                        )
                                ))));
    }

}