package za.ca.cput.busticketing.controller.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ca.cput.busticketing.entity.user.User;
import za.ca.cput.busticketing.factory.user.UserFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private static final String BASE_URL = "http://localhost:8080/user/";
    @BeforeEach
    void setUp() {
    }

    @Test
    void viewUsersPage() {
    }

    @Test
    void addUser() {
            String url = BASE_URL + "save";
            User user = UserFactory.build("Sanele", "Ngwenya","0733809897","manyMunya@gmail.com","#wwww");
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
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}