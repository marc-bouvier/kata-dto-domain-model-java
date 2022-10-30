package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ConceptResponseDto implements Serializable{

    // N° de serialisation
    Date creation;
    List<DefinitionDto> definitions;

    public static class DefinitionDto {

        public String name;
        public String contenu;
        public Set<String> tags;
    }
}
