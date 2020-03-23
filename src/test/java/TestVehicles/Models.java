package TestVehicles;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Models {
	
	@Test
	public void testModels() {
		
		int pgNumber = 1;
		
		given().
			pathParam("pageNumber", pgNumber).
		when().
			get("http://swapi.co/api/vehicles/?page={pageNumber}").
		then()
			.statusCode(200).and()
			.contentType("application/json")
			.assertThat().body("results[0].model", equalTo("Digger Crawler")).and()
			.assertThat().body("results[1].model", equalTo("T-16 skyhopper")).and()
			.assertThat().body("results[2].model", equalTo("X-34 landspeeder"));
	}
	
}
