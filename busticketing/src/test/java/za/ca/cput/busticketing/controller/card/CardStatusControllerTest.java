package za.ca.cput.busticketing.controller.card;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ca.cput.busticketing.entity.card.CardStatus;
import za.ca.cput.busticketing.factory.card.CardStatusFactory;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 *
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CardStatusControllerTest {
private static CardStatus cardStatus = new CardStatusFactory().build("Munya","student");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/cardStatus";
    public static String SECURITY_USERNAME= "user";
    public static String SECURITY_PASSWORD= "password";


    @Test
    void addCardStatus() {
    }

    @Test
    void displayAddCardStatusForm() {
        String url = BASE_URL + "read/" + cardStatus.getId();
        System.out.println("URL: " + url);
        ResponseEntity<CardStatus> response = restTemplate.withBasicAuth("user","password").getForEntity(url,CardStatus.class);
        assertEquals(response.getBody().getId(),response.getBody().getId());
    }

    @Test
    void showUpdateForm() {
        String url = BASE_URL + "read/" + cardStatus.getId();
        System.out.println("URL: " + url);
        ResponseEntity<CardStatus> response = restTemplate.withBasicAuth("user","password").getForEntity(url,CardStatus.class);
        assertEquals(response.getBody().getId(),response.getBody().getId());
    }

    @Test
    void updateCardStatus() {
        CardStatus updated = new CardStatus.Builder().copy(cardStatus).setDescription("Student").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<CardStatus> response = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url, updated, CardStatus.class);
        assertNotNull(response.getBody());
    }

    @Test
    void deleteCardStatus() {
        String url = BASE_URL +"/delete/" + cardStatus.getId();
        System.out.println("URL:" + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).delete(url);
    }
}