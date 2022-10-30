package controller;

import dto.ConceptResponseDto;
import dto.DefinitionsByTagResponseDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static controller.Fixtures.getConceptRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class EntityDtoConceptControllerTest {

    @Test
    void test() {

        // Arrange (Given)
        EntityDtoConceptController controller = setup();


        // Act (When)
        List<ConceptResponseDto> all = controller.all();


        // Assert (Then)
        assertAll(
                () -> assertThat(all).hasSize(1),
                () -> assertThat(all.get(0).definitions).hasSize(3));

    }

    @Test
    void test2() {

        // Arrange (Given)
        EntityDtoConceptController controller = setup();


        // Act (When)
        DefinitionsByTagResponseDto definitionsByTag = controller.findDefinitionsByTag("Java");


        // Assert (Then)
        assertAll(
                () -> assertThat(definitionsByTag.definitions).hasSize(2),
                () -> assertThat(definitionsByTag.definitions.get(0)).isNotNull());

    }


    @Test
    void filteredDefinitionsBeforeAllConcepts() {

        // Arrange (Given)
        EntityDtoConceptController controller = setup();

        // Act (When)
        DefinitionsByTagResponseDto definitionsByTag = controller.findDefinitionsByTag("Java");
        List<ConceptResponseDto> concepts = controller.all();

        List<ConceptResponseDto.DefinitionDto> definitions = concepts.get(0).definitions;

        // Assert (Then)
        ConceptResponseDto.DefinitionDto first = definitions.get(0);

        assertAll(
                () -> assertThat(first.name).describedAs("definition.name").isNotNull(),
                () -> assertThat(first.contenu).describedAs("definition.contenu").isNotNull(),
                () -> assertThat(first.tags).describedAs("definition.tags").isNotNull(),
                () -> assertThat(definitions).hasSize(3),
                () -> assertThat(definitionsByTag.definitions).hasSize(2));


    }


    private EntityDtoConceptController setup() {
        return new EntityDtoConceptController(getConceptRepository());
    }


}