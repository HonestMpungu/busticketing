package za.ca.cput.busticketing.controller.bus;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ca.cput.busticketing.entity.bus.Capacity;
import za.ca.cput.busticketing.factory.busfactory.CapacityFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class CapacityControllersTest {
    private static Capacity capacity = new CapacityFactory().create("Translux", "Available Seats");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/capacity";
    public static String SECURITY_USERNAME= "admin";
    public static String SECURITY_PASSWORD= "BusTicketing";

    @Test
    void showUpdateForm() {
        String url = BASE_URL + "read/" + capacity.getId();
        System.out.println("URL: " + url);
        ResponseEntity<Capacity> response = restTemplate.withBasicAuth("admin","BusTicketing").getForEntity(url,Capacity.class);
        assertEquals(response.getBody().getId(),response.getBody().getId());
    }

    @Test
    void updateCapacity() {
        Capacity updated = new Capacity.Builder().copy(capacity).setDescription("book").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<Capacity> response = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url, updated, Capacity.class);
        assertNotNull(response.getBody());
    }

    @Test
    void deleteCapacity() {
        String url = BASE_URL +"/delete/" + capacity.getId();
        System.out.println("URL:" + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).delete(url);
    }
}