package ssm.test.springresttemplate;

import org.junit.Test;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;

public class SpringRestTemplateHearder {
    public class UserAgentInterceptor implements ClientHttpRequestInterceptor {
        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
                throws IOException {
            HttpHeaders headers = request.getHeaders();
            headers.add(HttpHeaders.USER_AGENT,
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
            return execution.execute(request, body);
        }
    }

    @Test
    public void testGetHeader() throws UnsupportedEncodingException {
        String url = "http://localhost:8080/agent?name=一灰灰Blog";
        URLEncoder.encode(url, "utf-8");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new UserAgentInterceptor()));
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response.getStatusCode() + " | " + response.getBody());
    }

    @Test
    public void testPostHeader() {
        String url = "http://localhost:8080/post2";
        String email = "test@hhui.top";
        String nick = "一灰灰Blog";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("email", email);
        params.add("nick", nick);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        System.out.println(response.getStatusCode() + " | " + response.getBody());
    }


    @Test
    public void testExchange() {
        String url = "http://localhost:8080/post2";
        String email = "test@hhui.top";
        String nick = "一灰灰Blog";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("email", email);
        params.add("nick", nick);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        System.out.println(response.getStatusCode() + " | " + response.getBody());
    }
}
