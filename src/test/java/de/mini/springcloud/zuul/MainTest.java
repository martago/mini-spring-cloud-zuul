package de.mini.springcloud.zuul;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.LinkedHashMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void exampleTest() {
        LinkedHashMap<String, Object> myLinkedHasMap = this.restTemplate.getForObject("/abc", LinkedHashMap.class);

        assertThat(myLinkedHasMap.get("userId"), is(1));
        assertThat(myLinkedHasMap.get("id"), is(1));
    }

}