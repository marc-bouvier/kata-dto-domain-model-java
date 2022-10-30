package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.ConceptEntity;
import entities.DefinitionEntity;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


// ici, utiliser @JsonProperty("XXXX") permet de
// découpler le nom de l'attribut du nom utilisé dans le JSON (et donc Swagger).
public class ConceptResponseDto implements Serializable {

    // N° de serialisation
    @JsonProperty("creationDate")
    public Date creation;
    public List<DefinitionDto> definitions;

    public ConceptResponseDto(ConceptEntity conceptEntity) {
        this.creation = conceptEntity.creation;
        this.definitions = DefinitionDto.fromList(conceptEntity.definitions);
    }

    // Mapper à la main:
    // Il existe aussi des outils comme Mapstruct / Dozer pour le faire
    public static List<ConceptResponseDto> fromList(List<ConceptEntity> all) {
        return all.stream()
                .map(ConceptResponseDto::new)
                .collect(Collectors.toList());
    }

    // Classe interne pour signifier explicitement qu'elle n'a pas de sens en dehors de ConceptResponseDto
    public static class DefinitionDto {

        public String name;
        public String contenu;
        public Set<String> tags;

        public DefinitionDto(DefinitionEntity definitionEntity) {
            this.name = definitionEntity.name;
            this.contenu = definitionEntity.contenu;
            // Pour éviter de modifer les vrais objets on crée une copie non moifiable
            this.tags = Collections.unmodifiableSet(new HashSet<>(definitionEntity.tags));
        }

        public static List<DefinitionDto> fromList(List<DefinitionEntity> definitions) {
            return definitions.stream()
                    .map(DefinitionDto::new)
                    .collect(Collectors.toList());
        }
    }
}
