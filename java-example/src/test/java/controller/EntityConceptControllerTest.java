package controller;

import entities.ConceptEntity;
import entities.DefinitionEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class EntityConceptControllerTest {

    @Test
    void allConcepts() {

        // Arrange (Given)
        EntityConceptController controller = setup();


        // Act (When)
        List<ConceptEntity> all = controller.all();


        // Assert (Then)
        assertAll(
                () -> assertThat(all).hasSize(1),
                () -> assertThat(all.get(0).definitions).hasSize(3));

    }

    @Test
    void filteredDefinitions() {

        // Arrange (Given)
        EntityConceptController controller = setup();


        // Act (When)
        List<DefinitionEntity> definitions = controller.findDefinitionsByTag("Java");


        // Assert (Then)
        assertAll(
                () -> assertThat(definitions).hasSize(2),
                () -> assertThat(definitions.get(0).name).isNotNull(),
                () -> assertThat(definitions.get(0).contenu).isNull(),
                () -> assertThat(definitions.get(0).tags).isNull());

    }


    @Test
    void filteredDefinitionsBeforeAllConcepts() {

        // Arrange (Given)
        EntityConceptController controller = setup();

        // Act (When)
        controller.findDefinitionsByTag("Java");
        List<ConceptEntity> concepts = controller.all();
        List<DefinitionEntity> definitions = concepts.get(0).definitions;

        // Assert (Then)
        //FIXME : ICI, ce test test échoue car en voulant retourner uniquement le nom des définitions dans
        //  controller.findDefinitionsByTag("Java");
        //  nous avons modifié les instances de DefinitionEntity
        //  Egalement, si ces Entity etaient gérées par JPA et selon la configurations elles auraient pu exécuter des
        //  requêtes SQL qui modifient les données à notre insu
        //
        //  Utiliser des DTO et des mappers nous aurait protégé de ce phénomène
        //  Utiliser des copies non modifiables des collections aurait encore amélioré cela
        assertAll(
                () -> assertThat(definitions.get(0).name).describedAs("definition.name").isNotNull(),
                () -> assertThat(definitions.get(0).contenu).describedAs("definition.contenu").isNotNull(),
                () -> assertThat(definitions.get(0).tags).describedAs("definition.tags").isNotNull(),
                () -> assertThat(definitions).hasSize(3));
    }

    private EntityConceptController setup() {
        return new EntityConceptController(Fixtures.getConceptRepository());
    }


}