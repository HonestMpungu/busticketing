package za.ca.cput.busticketing.controller.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ca.cput.busticketing.entity.user.User;
import za.ca.cput.busticketing.factory.user.UserFactory;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 *
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
    private static User user= new UserFactory().build("Munya","Manyati", "0733333333", "manyMunya@gmail.com","#wwww");

    @Autowired
    private TestRestTemplate restTemplate;
    private static final String BASE_URL = "http://localhost:8080/user/";
    public static String SECURITY_USERNAME= "user";
    public static String SECURITY_PASSWORD= "password";

    @BeforeEach
    void setUp() {
    }

    @Test
    void viewUsersPage() {
    }

    @Test
    void addUser() {
            String url = BASE_URL + "save";
            User user = UserFactory.build("Sanele", "Ngwenya","0733333333","manyMunya@gmail.com","#wwww");
            ResponseEntity<User> result = restTemplate
                    .withBasicAuth("admin", "admin@123")
                    .postForEntity(url,user, User.class);
            System.out.println(result.getBody());
            assertEquals(HttpStatus.OK, result.getStatusCode());
        }



    @Test
    void displayAddUserForm() {
    }

    @Test
    void showUpdateForm() {
        String url = BASE_URL + "read/" + user.getId();
        System.out.println("URL: " + url);
        ResponseEntity<User> response = restTemplate.withBasicAuth("user","password").getForEntity(url, User.class);
        assertEquals(response.getBody().getId(),response.getBody().getId());
    }

    @Test
    void updateUser() {
        User updated = new User.Builder().copy(user).setId(3434).build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<User> response = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url, updated, User.class);
        assertNotNull(response.getBody());
    }

    @Test
    void deleteUser() {
        String url = BASE_URL +"/delete/" + user.getId();
        System.out.println("URL:" + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).delete(url);
    }
}