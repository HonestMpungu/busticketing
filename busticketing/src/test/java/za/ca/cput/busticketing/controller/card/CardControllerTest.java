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
import za.ca.cput.busticketing.entity.card.Card;

//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
////@ExtendWith(SpringExtension.class)
//public class CardControllerTest {
//
//    //private  static Card card = CardFactory.create("01/03/2010",250,"Green");
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private final String BASE_URL = "http://localhost:8080/card ";
//    public static String SECURITY_USERNAME= "admin";
//    public static String SECURITY_PASSWORD= "BusTicketing";
//
//    @Test
//    void create() {
//        String url = BASE_URL +"/";
//        ResponseEntity<Card> postResponse = restTemplate
//                .withBasicAuth("admin","BusTicketing")
//                .postForEntity(url,card,Card.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        card = postResponse.getBody();
//        System.out.println("Saved data: " + card);
//        assertEquals(card.getId(),postResponse.getBody().getId());
//    }
//    @Test
//    void read() {
//        String url = BASE_URL + "/" + card.getId();
//        System.out.println(" URL:" + url);
//        ResponseEntity<Card> response = restTemplate
//                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
//                .getForEntity(url,Card.class);
//
//    }
//
//    @Test
//    void delete() {
//        String url = BASE_URL + "/delete" +card.getId();
//        System.out.println("URL:" +url);
//        restTemplate.delete(url);
//    }
//    @Test
//    void getAll() {
//        String url =BASE_URL + "/getall";
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null,headers);
//        ResponseEntity<String> response = restTemplate
//                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
//                .exchange(url, HttpMethod.GET,entity,String.class);
//        System.out.println("Show Yellow Card");
//        System.out.println(response);
//        System.out.println(response.getBody());
//    }
//    @Test
//    void getallcardsforpensioners() {
//    }
//}
