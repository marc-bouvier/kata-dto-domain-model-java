package domain;

import java.util.Date;

public class Concept {
    // données
    private final Date creation;
    private final Definitions definitions;

    Concept(Date creation, Definitions definitions) {
        this.creation = creation;
        this.definitions = definitions;
    }


    // comportement
    public Definitions definitionsFor(Tag tag){
        throw new UnsupportedOperationException("Pas encore implémenté");
    }
}