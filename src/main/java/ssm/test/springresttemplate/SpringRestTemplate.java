package ssm.test.springresttemplate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class SpringRestTemplate {
    private RestTemplate restTemplate;

    @Before
    public void init() {
        restTemplate = new RestTemplate();
    }

    @lombok.Data
    static class InnerRes {
        private Status status;
        private Data result;
    }

    @lombok.Data
    static class Status {
        int code;
        String msg;
    }

    @lombok.Data
    static class Data {
        long id;
        String theme;
        String title;
        String dynasty;
        String explain;
        String content;
        String author;
    }

    @Test
    public void testGet() {
        // 使用方法一，不带参数
        String url = "https://story.hhui.top/detail?id=666106231640";
        InnerRes res = restTemplate.getForObject(url, InnerRes.class);
        System.out.println(res);


        // 使用方法一，传参替换
        url = "https://story.hhui.top/detail?id={?}";
        res = restTemplate.getForObject(url, InnerRes.class, "666106231640");
        System.out.println(res);

        // 使用方法二，map传参
        url = "https://story.hhui.top/detail?id={id}";
        Map<String, Object> params = new HashMap<>();
        params.put("id", 666106231640L);
        res = restTemplate.getForObject(url, InnerRes.class, params);
        System.out.println(res);

        // 使用方法三，URI访问
        URI uri = URI.create("https://story.hhui.top/detail?id=666106231640");
        res = restTemplate.getForObject(uri, InnerRes.class);
        System.out.println(res);
    }

    @Test
    public void testGetForEntity() {
        String url = "https://story.hhui.top/detail?id=666106231640";
        ResponseEntity<InnerRes> res = restTemplate.getForEntity(url, InnerRes.class);
        System.out.println(res);
    }

    @Test
    public void testPost() {
        String url = "http://localhost:8080/post";
        String email = "test@hhui.top";
        String nick = "一灰灰Blog";

        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("email", email);
        request.add("nick", nick);

        // 使用方法三
        URI uri = URI.create(url);
        String ans = restTemplate.postForObject(uri, request, String.class);
        System.out.println(ans);

        // 使用方法一
        ans = restTemplate.postForObject(url, request, String.class);
        System.out.println(ans);

        // 使用方法一，但是结合表单参数和uri参数的方式，其中uri参数的填充和get请求一致
        request.clear();
        request.add("email", email);
        ans = restTemplate.postForObject(url + "?nick={?}", request, String.class, nick);
        System.out.println(ans);


        // 使用方法二
        Map<String, String> params = new HashMap<>();
        params.put("nick", nick);
        ans = restTemplate.postForObject(url + "?nick={nick}", request, String.class, params);
        System.out.println(ans);
    }

    @Test
    public void testPostLocation() throws UnsupportedEncodingException {
        String url = "http://localhost:8080/post";
        String email = "test@hhui.top";
        String nick = "hhui_blog中文";
        nick = URLEncoder.encode(nick, "utf-8");

        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("email", email);
        request.add("nick", nick);

        // 使用方法三
        URI uri = restTemplate.postForLocation(url, request);
        System.out.println(uri);
    }

    @Test
    public void testPostLocation2() throws UnsupportedEncodingException {
        String url = "http://localhost:8080/post";
        String email = "test@hhui.top";
        String nick = "hhui_blog中文";
        nick = URLEncoder.encode(nick, "utf-8");

        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("email", email);
        request.add("nick", nick);

        // 使用方法三
        String uri = restTemplate.postForObject(url, request, String.class);
        System.out.println(uri);
    }


}
