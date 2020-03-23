package TestVehicles;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class Crews {
	
	@Test
	public void testCrews() {
		
		int pgNumber = 1;
		
		given().
			pathParam("pageNumber", pgNumber).
		when().
			get("http://swapi.co/api/vehicles/?page={pageNumber}").
		then()
			.statusCode(200).and()
			.contentType("application/json")
			.assertThat().body("results[0].crew", equalTo("46")).and()
			.assertThat().body("results[1].crew", equalTo("1")).and()
			.assertThat().body("results[2].crew", equalTo("1"));
	}

}
