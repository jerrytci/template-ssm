package ssm.test.springresttemplate;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

public class SpringRestTemplateFile {
    @Test
//    todo
    public void testPostFile() {
        String url = "http://localhost:8080/file";
        FileSystemResource resource = new FileSystemResource(new File("/tmp/test_SRTF.txt"));
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("file", resource);
        params.add("fileName", "test.txt");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, params, String.class);
        System.out.println(response);
    }
}
