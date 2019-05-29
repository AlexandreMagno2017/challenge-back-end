package br.com.amedigital.vo;

import java.util.ArrayList;
import java.util.List;

public class Envelope {

	private int count;
	private String next; // "next":"https://swapi.co/api/planets/?page=2",
	private String previous; // "previous":null,
	List<PlanetVO> results;

	public Envelope() {
		results = new ArrayList<>();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public List<PlanetVO> getResults() {
		return results;
	}

	public void setResults(List<PlanetVO> results) {
		this.results = results;
	}

}
