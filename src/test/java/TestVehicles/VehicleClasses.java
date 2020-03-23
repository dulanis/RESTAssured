package TestVehicles;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class VehicleClasses {
	
	@Test
	public void testVehicleClass() {
		
		int pgNumber = 1;
		
		given().
			pathParam("pageNumber", pgNumber).
		when().
			get("http://swapi.co/api/vehicles/?page={pageNumber}").
		then()
			.statusCode(200).and()
			.contentType("application/json")
			.assertThat().body("results[0].vehicle_class", equalTo("wheeled")).and()
			.assertThat().body("results[1].vehicle_class", equalTo("repulsorcraft")).and()
			.assertThat().body("results[2].vehicle_class", equalTo("repulsorcraft"));
	}

}
