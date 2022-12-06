package com.instagram.instagram.user;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")

public class UserControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;
    @Autowired
    UserRepository userRepository;

    @Before
    public void cleanup(){
        userRepository.deleteAll();

    }
    private static  final String API_1_0_USERS="/api/1.0/users";
    @Test
    public void postUser_whenUserIsValid_recievedOk() {

User user=createValiduser();
        ResponseEntity<Object> responce = testRestTemplate.postForEntity(API_1_0_USERS, user, Object.class);
        assertEquals(responce.getStatusCode(), HttpStatus.OK);


    }

    private User createValiduser() {
        User user = new User();
        user.setUsername("test-user");
        user.setDisplayName("test-display");
        user.setPassword("password");
        return user;
    }

    @Test
    public void postUser_whenuserIsValid_usersavedToDatabase() {
        User user=createValiduser();
        testRestTemplate.postForEntity(API_1_0_USERS, user, Object.class);
        assertEquals(userRepository.count(),1);

    }
}