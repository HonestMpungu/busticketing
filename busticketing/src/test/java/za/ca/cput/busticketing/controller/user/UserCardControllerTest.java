package za.ca.cput.busticketing.controller.user;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ca.cput.busticketing.entity.card.CardStatus;
import za.ca.cput.busticketing.entity.user.UserCard;
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
class UserCardControllerTest {

    private static CardStatus userCard = new CardStatusFactory().build("Munya","student");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/userCard";
    public static String SECURITY_USERNAME= "user";
    public static String SECURITY_PASSWORD= "password";
    @Test
    void addUserCard() {
    }

    @Test
    void showUpdateForm() {
        String url = BASE_URL + "read/" + userCard.getId();
        System.out.println("URL: " + url);
        ResponseEntity<UserCard> response = restTemplate.withBasicAuth("user","password").getForEntity(url, UserCard.class);
        assertEquals(response.getBody().getId(),response.getBody().getId());
    }

    @Test
    void updateUserCard() {

        CardStatus updated = new CardStatus.Builder().copy(userCard).setDescription("Student").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<UserCard> response = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url, updated, UserCard.class);
        assertNotNull(response.getBody());
    }

    @Test
    void deleteUserCard() {
        String url = BASE_URL +"/delete/" + userCard.getId();
        System.out.println("URL:" + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).delete(url);
    }
}