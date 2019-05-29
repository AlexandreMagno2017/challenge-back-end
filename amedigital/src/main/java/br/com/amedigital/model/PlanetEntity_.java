package br.com.amedigital.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-05-29T01:01:05.051-0300")
@StaticMetamodel(PlanetEntity.class)
public class PlanetEntity_ {
	public static volatile SingularAttribute<PlanetEntity, Long> id;
	public static volatile SingularAttribute<PlanetEntity, String> name;
	public static volatile SingularAttribute<PlanetEntity, String> climate;
	public static volatile SingularAttribute<PlanetEntity, String> terrain;
	public static volatile SingularAttribute<PlanetEntity, Date> cdate;
	public static volatile SingularAttribute<PlanetEntity, Integer> totalFilms;
}
