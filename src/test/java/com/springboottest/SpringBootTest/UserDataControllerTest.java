package com.springboottest.SpringBootTest;

import com.springboottest.SpringBootTest.dto.UserAccessRequest;
import com.springboottest.SpringBootTest.model.UserData;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserDataControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testRegistrationAndLogin() {
        // Registration
        UserAccessRequest registrationRequest = new UserAccessRequest("testuser", "password123");
        ResponseEntity<UserData> registrationResponse = restTemplate.postForEntity("/register", registrationRequest, UserData.class);

        assertEquals(200, registrationResponse.getStatusCodeValue());
        UserData registeredUserData = registrationResponse.getBody();
        assertEquals("testuser", registeredUserData.getUsername());         
    }

    @Test
    @Disabled
    public void testLogin() {
        // Login
        UserAccessRequest loginRequest = new UserAccessRequest("testuser", "password123");
        ResponseEntity<UserData> loginResponse = restTemplate.postForEntity("/api/users/login", loginRequest, UserData.class);

        assertEquals(200, loginResponse.getStatusCodeValue());
        UserData loggedInUser = loginResponse.getBody();
        assertEquals("testuser", loggedInUser.getUsername());
    }
}
