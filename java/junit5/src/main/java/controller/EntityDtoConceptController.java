package controller;

// Couplage TRES fort

// les noms des attributs de nos Entity correspondent aux noms des colonnes dans SQL
// les noms des attributs de nos Entity correspondent aux noms des attributs dans le JSON retourné
// - Changer un nom d'attribut d'Entity => Changement de SQL ET un changement de Swagger


import dao.ConceptRepository;
import dto.ConceptResponseDto;
import dto.DefinitionsByTagResponseDto;

import java.util.List;


// Risque de sécurité (on dévoile indirectement la structure de la base de données)
// Quand les Entity changent, ca change automatiquement les Controllers (et swagger)
//   - Problème de contrat d'interface avec l'extérieur
//   - Risque de changement cassant des consommateurs de l'API si le contrat change
//
public class EntityDtoConceptController {

    private final ConceptRepository conceptRepository;

    // @Autowired
    public EntityDtoConceptController(ConceptRepository conceptRepository) {
        this.conceptRepository = conceptRepository;
    }

    public List<ConceptResponseDto> all() {
        return ConceptResponseDto
                .fromList(conceptRepository.findAll());
    }

    public DefinitionsByTagResponseDto findDefinitionsByTag(String tag) {
        return DefinitionsByTagResponseDto
                .fromList(conceptRepository.findAllDefinitionsByTag(tag));
    }
}