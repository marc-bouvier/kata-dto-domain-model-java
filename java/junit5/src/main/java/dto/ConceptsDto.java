package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ConceptsDto implements Serializable{

    // N° de serialisation
    Date creation;
    List<DefinitionDto> definitions;
}
