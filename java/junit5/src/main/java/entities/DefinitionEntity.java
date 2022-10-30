package entities;

import java.util.Set;

public class DefinitionEntity {
    public String name;
    public String contenu;
    public Set<String> tags;

    public DefinitionEntity(String name, String contenu, Set<String> tags) {
        this.name = name;
        this.contenu = contenu;
        this.tags = tags;
    }

    public DefinitionEntity() {
    }
}


