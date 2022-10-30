package controller;

// Couplage TRES fort

// les noms des attributs de nos Entity correspondent aux noms des colonnes dans SQL
// les noms des attributs de nos Entity correspondent aux noms des attributs dans le JSON retourné
// - Changer un nom d'attribut d'Entity => Changement de SQL ET un changement de Swagger


import dao.ConceptRepository;
import entities.ConceptEntity;
import entities.DefinitionEntity;

import java.util.List;


// Risque de sécurité (on dévoile indirectement la structure de la base de données)
// Quand les Entity changent, ca change automatiquement les Controllers (et swagger)
//   - Problème de contrat d'interface avec l'extérieur
//   - Risque de changement cassant des consommateurs de l'API si le contrat change
//
public class EntityConceptController {

    private final ConceptRepository conceptRepository;

    // @Autowired
    public EntityConceptController(ConceptRepository conceptRepository) {
        this.conceptRepository = conceptRepository;
    }

    public List<ConceptEntity> all() {
        return conceptRepository.findAll();
    }

    public List<DefinitionEntity> findDefinitionsByTag(String tag) {
        List<DefinitionEntity> definitons = conceptRepository.findAllDefinitionsByTag(tag);


        for (DefinitionEntity definiton : definitons) {
            definiton.tags=null;
            definiton.contenu=null;
        }

        return definitons;
        // risque de modifier les données de la base de données selon la configuration de JPA
    }
}