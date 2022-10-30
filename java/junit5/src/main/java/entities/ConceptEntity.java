package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ConceptEntity implements Serializable{

    // N° de serialisation
   public  Date creation;
    public List<DefinitionEntity> definitions;

    public ConceptEntity(Date creation, List<DefinitionEntity> definitions) {
        this.creation = creation;
        this.definitions = definitions;
    }

    public ConceptEntity() {
    }
}
