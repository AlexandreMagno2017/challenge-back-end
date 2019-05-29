package br.com.amedigital.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.amedigital.model.PlanetEntity;
import br.com.amedigital.services.PlanetService;
import br.com.amedigital.vo.Envelope;
import br.com.amedigital.vo.PlanetVO;

@RestController
@RequestMapping("planets")
public class PlanetController {

	@Autowired
	private PlanetService planetService;

	@Autowired
	public Gson gson;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody PlanetVO vo) {
		try {
			PlanetVO save = planetService.save(vo);
			return ResponseEntity.ok().body(gson.toJson(save));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<PlanetVO> findByName(@RequestParam("name") String name) {
		Optional<PlanetEntity> opt = planetService.findByName(name);
		if (opt.isPresent())
			return ResponseEntity.ok().body(new PlanetVO(opt.get()));
		return ResponseEntity.notFound().build();
	}

	@GetMapping(value = "/database", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<PlanetVO> all() {
		System.out.println("all() ");
		return planetService.findAll();
	}

	@GetMapping(value = "/starwarsapi", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<PlanetVO> listPlanetsApi() {
		System.out.println("listPlanetsApi() ");
		return planetService.listPlanetsApi();
	}

	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlanetVO> findById(@PathVariable("id") Long id) {
		Optional<PlanetEntity> opt = planetService.findById(id);
		if (opt.isPresent())
			return ResponseEntity.ok().body(new PlanetVO(opt.get()));
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removeById(@PathVariable("id") Long id) {
		int removeById = planetService.removeById(id);
		return removeById > 0 ? ResponseEntity.ok().body("Removed successfully.") : ResponseEntity.notFound().build();
	}

	@RequestMapping(path = "/populate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Envelope> populate() {
		System.out.println("populate() ");
		planetService.populate();
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
