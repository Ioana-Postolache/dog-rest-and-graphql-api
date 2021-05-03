package com.udacity.bootstrap.web;

import com.udacity.bootstrap.entity.Dog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllDogs() {
        ResponseEntity<Dog[]> response =
                this.restTemplate.withBasicAuth("admin", "password").getForEntity("http://localhost:" + port + "/dogs/", Dog[].class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogBreedById() {
        ResponseEntity<String> response =
                this.restTemplate.withBasicAuth("admin", "password").getForEntity("http://localhost:" + port + "/dog/1/breed", String.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

}
