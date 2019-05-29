package br.com.amedigital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "planet")
public class PlanetEntity {

	@Id
	@Column(name = "id")

	/*
	 * Para H2, deve-se considerar o GenerationType.AUTO e retirar a
	 * configuraçao de banco Mysql do application.properties.
	 */
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", length = 64)
	private String name;

	@Column(name = "climate", length = 64)
	private String climate;

	@Column(name = "terrain", length = 64)
	private String terrain;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cdate")
	private Date cdate;
	
	@Column(name = "total_films")
	private int totalFilms;

	public PlanetEntity() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param climate
	 * @param terrain
	 */
	public PlanetEntity(String name, String climate, String terrain) {
		super();
		this.name = name;
		this.climate = climate;
		this.terrain = terrain;
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

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public int getTotalFilms() {
		return totalFilms;
	}

	public void setTotalFilms(int totalFilms) {
		this.totalFilms = totalFilms;
	}
}
