package dto;

import entities.ConceptEntity;
import entities.DefinitionEntity;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConceptResponseDto implements Serializable {

    // N° de serialisation
    public Date creation;
    public List<DefinitionDto> definitions;

    public ConceptResponseDto(ConceptEntity conceptEntity) {
        this.creation = conceptEntity.creation;
        this.definitions = DefinitionDto.fromList(conceptEntity.definitions);
    }

    // Mapper
    // Mapstruct / Dozer
    public static List<ConceptResponseDto> fromList(List<ConceptEntity> all) {
        return all.stream()
                .map(ConceptResponseDto::new)
                .collect(Collectors.toList());
    }

    public static class DefinitionDto {

        public String name;
        public String contenu;
        public Set<String> tags;

        public DefinitionDto(DefinitionEntity definitionEntity) {
            this.name = definitionEntity.name;
            this.contenu = definitionEntity.contenu;
            this.tags = Collections.unmodifiableSet(new HashSet<>(definitionEntity.tags));
        }

        public static List<DefinitionDto> fromList(List<DefinitionEntity> definitions) {
            return definitions.stream()
                    .map(DefinitionDto::new)
                    .collect(Collectors.toList());
        }
    }
}
