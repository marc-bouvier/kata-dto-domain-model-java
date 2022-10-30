package domain;

public class Definition {
    private final String name;
    private final Contenu contenu;
    private final Tags tags;

    public Definition(String name, Contenu contenu, Tags tags) {
        this.name = name;
        this.contenu = contenu;
        this.tags = tags;
    }
}
