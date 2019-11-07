package ssm.controller.springresttemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringRestTemplateJson {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Req {
        private String key;
        private Integer size;
    }

    @ResponseBody
    @RequestMapping(value = "/body", method = {RequestMethod.POST, RequestMethod.GET, RequestMethod.OPTIONS})
    public String body(@RequestBody Req req) {
        return req.toString();
    }
}
