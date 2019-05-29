package br.com.amedigital;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class PlanetControllerTest {
	
	/*@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PlanetRepository planetRepository;
*/
	/*
	 * @Test public void savedSuccessfully() { // given PlanetEntity entity =
	 * new PlanetEntity("Plutao", "dry", "dry"); entityManager.persist(entity);
	 * entityManager.flush();
	 * 
	 * // when Optional<PlanetEntity> found =
	 * planetRepository.findByName(entity.getName());
	 * 
	 * // then assertThat(found.get().getName(), equalTo(entity.getName())); }
	 */

	@Test
	public void givenRequestWithNoAcceptHeader_whenRequestIsExecuted_thenDefaultResponseContentTypeIsJson()
			throws ClientProtocolException, IOException {

		// Given
		String jsonMimeType = "application/json";
		HttpUriRequest request = new HttpGet("https://swapi.co/api/planets/");

		// When
		HttpResponse response = HttpClientBuilder.create().build().execute(request);

		// Then
		String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
		assertEquals(jsonMimeType, mimeType);
	}
	
	@Test
	public void givenPlanetDoesNotExists_whenPlanetInfoIsRetrieved_then404IsReceived()
	  throws ClientProtocolException, IOException {

		// Given
		String id = "300";
		HttpUriRequest request = new HttpGet("http://localhost:8080/apis/planets/" + id);

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
	}

	
	@Test
	public void givenPlanetExists_whenPlanetInfoIsRetrieved_then200IsReceived()
	  throws ClientProtocolException, IOException {

		// Given
		String id = "22";
		HttpUriRequest request = new HttpGet("http://localhost:8080/apis/planets/" + id);
		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	}

}
