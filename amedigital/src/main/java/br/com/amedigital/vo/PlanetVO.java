package br.com.amedigital.vo;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.amedigital.model.PlanetEntity;

public class PlanetVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1566699745827620180L;

	private long id;

	private String name;

	private String climate;

	private String terrain;
	
	private ArrayList<String> films;
	
	private int totalFilms;

	public PlanetVO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param climate
	 * @param terrain
	 */
	public PlanetVO(String name, String climate, String terrain) {
		super();
		this.name = name;
		this.climate = climate;
		this.terrain = terrain;
	}

	public PlanetVO(PlanetEntity entity) {
		setName(entity.getName());
		setClimate(entity.getClimate());
		setTerrain(entity.getTerrain());
		setId(entity.getId());
		setTotalFilms(entity.getTotalFilms());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public ArrayList<String> getFilms() {
		return films;
	}

	public void setFilms(ArrayList<String> films) {
		this.films = films;
	}

	public int getTotalFilms() {
		return totalFilms;
	}

	public void setTotalFilms(int totalFilms) {
		this.totalFilms = totalFilms;
	}
}
