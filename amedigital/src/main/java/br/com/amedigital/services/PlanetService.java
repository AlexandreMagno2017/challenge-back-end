package br.com.amedigital.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.amedigital.model.PlanetEntity;
import br.com.amedigital.repository.PlanetRepository;
import br.com.amedigital.vo.Envelope;
import br.com.amedigital.vo.PlanetVO;

@Component
public class PlanetService {

	@Autowired
	private PlanetRepository planetRepository;

	@Autowired
	public RestTemplate restTemplate;

	@Autowired
	public Gson gson;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public PlanetVO save(PlanetVO vo) {
		PlanetEntity save = planetRepository.save(dtoToEntity(vo));
		return new PlanetVO(save);
	}

	public List<PlanetVO> findAll() {
		List<PlanetEntity> findAll = (List<PlanetEntity>) planetRepository.findAll();
		return findAll.stream().map(m -> {
			return entityToDTO(m);
		}).collect(Collectors.toList());
	}

	private PlanetEntity dtoToEntity(PlanetVO vo) {
		return new PlanetEntity(vo.getName(), vo.getClimate(), vo.getTerrain());
	}

	private PlanetVO entityToDTO(PlanetEntity entity) {
		return new PlanetVO(entity.getName(), entity.getClimate(), entity.getTerrain());
	}

	public void populate() {
		String url = "https://swapi.co/api/planets/";
		ResponseEntity<Envelope> result = makeRequest(url);
		while (result.getStatusCodeValue() < 300) {
			Envelope envelope = result.getBody();
			save(envelope);
			if (envelope.getNext() == null) {
				break;
			}
			result = makeRequest(envelope.getNext());
		}
	}

	public List<PlanetVO> listPlanetsApi() {
		String url = "https://swapi.co/api/planets/";
		ResponseEntity<Envelope> result = makeRequest(url);
		List<PlanetVO> listTotal = null;

		if (result.getStatusCodeValue() < 300) {
			listTotal = new ArrayList<>(result.getBody().getCount());
		} else
			return new ArrayList<>();

		while (result.getStatusCodeValue() < 300) {
			Envelope envelope = result.getBody();
			listTotal.addAll(envelope.getResults());
			if (envelope.getNext() == null) {
				break;
			}
			result = makeRequest(envelope.getNext());
		}
		return listTotal;
	}

	private ResponseEntity<Envelope> makeRequest(String url) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Envelope> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Envelope.class);
		return response;
	}

	private void save(Envelope envelope) {
		for (PlanetVO planetVO : envelope.getResults()) {
			PlanetEntity entity = new PlanetEntity(planetVO.getName(), planetVO.getClimate(), planetVO.getTerrain());
			entity.setTotalFilms(planetVO.getFilms().size());
			planetRepository.save(entity);
		}
	}

	public Optional<PlanetEntity> findByName(String name) {
		Optional<PlanetEntity> opt = planetRepository.findByName(name);
		return opt;
	}

	public Optional<PlanetEntity> findById(Long id) {
		Optional<PlanetEntity> opt = planetRepository.findById(id);
		return opt;
	}

	public int removeById(Long id) {
		Optional<PlanetEntity> opt = planetRepository.findById(id);
		if (opt.isPresent()) {
			planetRepository.delete(opt.get());
			return 1;
		}
		return 0;
	}

}
