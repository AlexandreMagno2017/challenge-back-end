package br.com.amedigital.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.amedigital.model.PlanetEntity;

public interface PlanetRepository extends CrudRepository<PlanetEntity, Long> {

    Optional<PlanetEntity> findByName(String name);
}
