package dto;

import entities.DefinitionEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefinitionsByTagResponseDto {

    public List<String> definitions;

    public DefinitionsByTagResponseDto(List<DefinitionEntity> allDefinitionsByTag) {
        this.definitions = allDefinitionsByTag.stream()
                .map(definitionEntity -> definitionEntity.name)
                .collect(Collectors.toList());

    }

    public static DefinitionsByTagResponseDto fromList(List<DefinitionEntity> allDefinitionsByTag) {
        return new DefinitionsByTagResponseDto(allDefinitionsByTag);
    }
}
