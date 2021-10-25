package za.ca.cput.busticketing.controller.bus;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ca.cput.busticketing.entity.bus.Bus;
import za.ca.cput.busticketing.factory.busfactory.BusFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class BusControllerTest {

    private static  Bus bus = new BusFactory().create("MecerBus", "book");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/bus";
    public static String SECURITY_USERNAME= "admin";
    public static String SECURITY_PASSWORD= "BusTicketing";

    @Test
    void showUpdateForm() {
        String url = BASE_URL + "read/" + bus.getId();
        System.out.println("URL: " + url);
        ResponseEntity<Bus> response = restTemplate.withBasicAuth("admin","BusTicketing").getForEntity(url, Bus.class);
        assertEquals(response.getBody().getId(),response.getBody().getId());
    }

    @Test
    void updateBus() {
        Bus updated = new Bus.Builder().copy(bus).setDescription("book").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<Bus> response = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url, updated, Bus.class);
        assertNotNull(response.getBody());
    }

    @Test
    void deleteBus() {
        String url = BASE_URL +"/delete/" + bus.getId();
        System.out.println("URL:" + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).delete(url);


    }
}