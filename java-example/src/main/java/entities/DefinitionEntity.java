package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Set;


// Ici, utiliser @Table(name="CXXX") et @Column(name="YYY")
// Permet de DECOUPLER le nom de l'attribut ou de la classe
// du nom de la table et des colonnes dans la base de données
// Si on change l'un, ça ne change pas l'autre
@Entity
@Table(name = "DEFINITION")
public class DefinitionEntity {

     @JsonProperty("name")
     @Column(name="NAME")
    public String name;
    @Column(name="CONTENU")
    public String contenu;
    //...
    public Set<String> tags;

    public DefinitionEntity(String name, String contenu, Set<String> tags) {
        this.name = name;
        this.contenu = contenu;
        this.tags = tags;
    }

    public DefinitionEntity() {
    }
}


