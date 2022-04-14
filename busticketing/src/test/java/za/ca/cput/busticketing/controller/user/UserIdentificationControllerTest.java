package za.ca.cput.busticketing.controller.user;

/**
 * @author anongxa
 * Student No:204513723
 * 23/09/2021
 */

TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class UserIdentificationControllerTest {

    private  static UserIdentification userIdentification = UserIdentificationFactory.create("Yellow Card","  Honest");

    @Autowired
    private TestRestTemplate restTemplate;
    public static String SECURITY_USERNAME= "user";
    public static String SECURITY_PASSWORD= "user generated";
    private final String BASE_URL = "http://localhost:8080/card ";

    @Test
    void create() {

        String url = BASE_URL +"/";
        ResponseEntity<UserIdentification> postResponse = restTemplate
                .withBasicAuth("Super","Pass")
                .postForEntity(url,userIdentification,UserIdentification.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        cardType = postResponse.getBody();
        System.out.println("Saved data: " + userIdentification);
        assertEquals(userIdentificationtype.getId(),postResponse.getBody().getId());
    }

    @Test
    void read() {
        String url = BASE_URL + "/" + userIdentification.getId();
        System.out.println(" URL:" + url);
        ResponseEntity<UserIdentification> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .getForEntity(url,UserIdentification.class);
        assertNotNull(response.getBody());
    }

    @Test
    void update() {
        UserIdentification updated =new UserIdentification.Builder().copy(userIdentification).setDescription("315").build();
        String url = BASE_URL + "/update";
        System.out.println("URL:"+url);
        System.out.println("Post data:"+ updated);
        ResponseEntity<CardType> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url,updated,UserIdentification.class);
        assertNotNull(response.getBody());
    }

    @Test
    void delete() {
        String url = BASE_URL + "/delete" +userIdentification.getId();
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
