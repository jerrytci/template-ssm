package ssm.test.springresttemplate;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class SpringRestTemplateJson {
    @Test
    public void testPostRequestBody() {
        String url = "http://localhost:8080/body";
        String email = "test@hhui.top";
        String nick = "一灰灰Blog";

        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("nick", nick);
        params.put("key", email);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpEntity<Map<String, String>> request = new HttpEntity<>(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        System.out.println(response.getStatusCode() + " | " + response.getBody());
    }
}
