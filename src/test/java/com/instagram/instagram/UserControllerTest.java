package com.instagram.instagram;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class UserControllerTest {

    @Autowired //field injection
    TestRestTemplate testRestTemplate;
    @Test
    public void postUserWhenUserIsValidReceiveOk(){
        User user = new User();

        user.setUsername("test-user");
        user.setDisplayName("test-display");
        user.setPassword("1234");

        ResponseEntity<Object> responce = testRestTemplate.postForEntity("/api/1.0/users", user, Object.class);

        assertEquals(responce.getStatusCode(), HttpStatus.OK);
    }
}