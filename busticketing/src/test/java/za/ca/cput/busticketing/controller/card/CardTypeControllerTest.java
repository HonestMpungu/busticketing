package za.ca.cput.busticketing.controller.card;


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
import za.ca.cput.busticketing.entity.card.CardType;
import za.ca.cput.busticketing.factory.card.CardTypeFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class CardTypeControllerTest {

    private  static CardType cardType = CardTypeFactory.create("Yellow Card","  Honest");

    @Autowired
    private TestRestTemplate restTemplate;
    public static String SECURITY_USERNAME= "user";
    public static String SECURITY_PASSWORD= "user generated";
    private final String BASE_URL = "http://localhost:8080/card ";

    @Test
    void create() {

        String url = BASE_URL +"/";
        ResponseEntity<CardType> postResponse = restTemplate
                .withBasicAuth("Super","Pass")
                .postForEntity(url,cardType,CardType.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        cardType = postResponse.getBody();
        System.out.println("Saved data: " + cardType);
        assertEquals(cardType.getId(),postResponse.getBody().getId());
    }

    @Test
    void read() {
        String url = BASE_URL + "/" + cardType.getId();
        System.out.println(" URL:" + url);
        ResponseEntity<CardType> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .getForEntity(url,CardType.class);
        assertNotNull(response.getBody());
    }

    @Test
    void update() {
        CardType updated =new CardType.Builder().copy(cardType).setDescription("315").build();
        String url = BASE_URL + "/update";
        System.out.println("URL:"+url);
        System.out.println("Post data:"+ updated);
        ResponseEntity<CardType> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url,updated,CardType.class);
        assertNotNull(response.getBody());
    }

    @Test
    void delete() {
        String url = BASE_URL + "/delete" +cardType.getId();
        System.out.println("URL:" +url);
        restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url =BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET,entity,String.class);

        System.out.println("Show Yellow Card");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}