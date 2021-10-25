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
import za.ca.cput.busticketing.entity.route.BusStop;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class BusStopControllerTest {
    private static BusStop busStop = BusStop.create("Cape Town");



    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/busRoute";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<BusStop> postResponse = restTemplate.postForEntity(url, busStop, BusStop.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        busStop = postResponse.getBody();
        System.out.println("Created data: " +busStop);
        assertEquals(busStop.getId(), postResponse.getBody().getId());

    }

    @Test
    void b_read() {
        String url = baseURL + "read" + busStop.getId();
        System.out.println("BusRoute Read URL:  " + url);
        ResponseEntity<BusStop> busStopResponseEntity = restTemplate.getForEntity(url, BusStop.class);
        assertNotNull(busStopResponseEntity);
        assertNotNull(busStopResponseEntity.getBody());
    }


    @Test
    void update() {
        BusStop.Builder busStopBuilder = new BusStop.Builder();
        busStopBuilder.copy(busStop).setDescription("Cape Town");
        BusStop updated  = busStopBuilder.build();
        String url = baseURL + "/update";
        System.out.println("busStop Update URL:  " + url);
        System.out.println("Updated busStop Name: " + updated);
        ResponseEntity<BusStop> response = restTemplate.postForEntity(url, updated, BusStop.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL+ "/delete/" + busStop.getId();
        System.out.println("busStop URL: " + url);
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
