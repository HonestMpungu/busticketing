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
import za.ca.cput.busticketing.entity.route.Route;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class RouteControllerTest {
    private static Route route = Route.create("Cape Town");



    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/busRoute";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Route> postResponse = restTemplate.postForEntity(url, route, Route.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        route = postResponse.getBody();
        System.out.println("Created data: " +route);
        assertEquals(route.getId(), postResponse.getBody().getId());

    }

    @Test
    void b_read() {
        String url = baseURL + "read" + route.getId();
        System.out.println("Route Read URL:  " + url);
        ResponseEntity<Route> routeResponseEntity = restTemplate.getForEntity(url, Route.class);
        assertNotNull(routeResponseEntity);
        assertNotNull(routeResponseEntity.getBody());
    }


    @Test
    void update() {
        Route.Builder routeBuilder = new Route.Builder();
        routeBuilder.copy(route).setDescription("Cape Town");
        Route updated  = routeBuilder.build();
        String url = baseURL + "/update";
        System.out.println("route Update URL:  " + url);
        System.out.println("Updated route Name: " + updated);
        ResponseEntity<Route> response = restTemplate.postForEntity(url, updated, Route.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL+ "/delete/" + route.getId();
        System.out.println("route URL: " + url);
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

