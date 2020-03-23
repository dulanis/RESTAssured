package TestVehicles;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class Names {
	
	@Test
	public void testNames() {
		
		int pgNumber = 1;
		
		given().
			pathParam("pageNumber", pgNumber).
		when().
			get("http://swapi.co/api/vehicles/?page={pageNumber}").
		then()
			.statusCode(200).and()
			.contentType("application/json")
			.assertThat().body("results[0].name", equalTo("Sand Crawler")).and()
			.assertThat().body("results[1].name", equalTo("T-16 skyhopper")).and()
			.assertThat().body("results[2].name", equalTo("X-34 landspeeder"));
	}

}
