package controller;


import dao.ConceptRepository;
import dto.ConceptResponseDto;
import dto.DefinitionsByTagResponseDto;

import java.util.List;


// Couplage MOINBS fort

// les noms des attributs de nos Entity correspondent aux noms des colonnes dans SQL
// les noms des attributs de nos DTO correspondent aux noms des attributs dans le JSON retourné
// - Changer un nom d'attribut d'Entity => Changement de SQL MAIS PAS un changement de Swagger
// - Changer un nom d'attribut dans DOT => Changement de Swagger MAIS PAS de SQL

// Sécurité on ne dévoile plus la structure de la base de données
// - on peut choisir de n'exposer que le stricit minimum côté API

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