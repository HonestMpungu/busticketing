package za.ca.cput.busticketing.controller.route;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ca.cput.busticketing.entity.route.BusRoute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringBootTest(webEnvironment = RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class BusRouteControllerTest {
    private static BusRoute busRoute = BusRoute.create("Cape Town");



    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/busRoute";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<BusRoute> postResponse = restTemplate.postForEntity(url, busRoute, BusRoute.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        busRoute = postResponse.getBody();
        System.out.println("Created data: " +busRoute);
        assertEquals(busRoute.getId(), postResponse.getBody().getId());

    }

    @Test
    void b_read() {
        String url = baseURL + "read" + busRoute.getId();
        System.out.println("BusRoute Read URL:  " + url);
        ResponseEntity<BusRoute> busRouteResponseEntity = restTemplate.getForEntity(url, BusRoute.class);
        assertNotNull(busRouteResponseEntity);
        assertNotNull(busRouteResponseEntity.getBody());
    }


    @Test
    void update() {
        BusRoute.Builder busRouteBuilder = new BusRoute.Builder();
        busRouteBuilder.copy(busRoute).setDescription("Cape Town");
        BusRoute updated  = busRouteBuilder.build();
        String url = baseURL + "/update";
        System.out.println("BusRoute Update URL:  " + url);
        System.out.println("Updated BusRoute Name: " + updated);
        ResponseEntity<BusRoute> response = restTemplate.postForEntity(url, updated, BusRoute.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL+ "/delete/" + busRoute.getId();
        System.out.println("BusRoute URL: " + url);
        restTemplate.delete(url);
    }


    @Test
    void getAll() {
        String url = baseURL + "getAll" ;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println("Get all URL:  " + url);
        System.out.println(response.getBody());

    }
}

