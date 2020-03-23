package TestVehicles;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Manufacturers {

	@Test
	public void testManufacturers() {
		
		int pgNumber = 1;
		
		given().
			pathParam("pageNumber", pgNumber).
		when().
			get("http://swapi.co/api/vehicles/?page={pageNumber}").
		then()
			.statusCode(200).and()
			.contentType("application/json")
			.assertThat().body("results[0].manufacturer", equalTo("Corellia Mining Corporation")).and()
			.assertThat().body("results[1].manufacturer", equalTo("Incom Corporation")).and()
			.assertThat().body("results[2].manufacturer", equalTo("SoroSuub Corporation"));
	}
	
}
