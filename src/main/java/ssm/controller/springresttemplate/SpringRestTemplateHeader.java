package ssm.controller.springresttemplate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
public class SpringRestTemplateHeader {
    @ResponseBody
    @RequestMapping(path = "agent")
    public String agent(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "name", required = false) String name) throws IOException {
        String agent = request.getHeader(HttpHeaders.USER_AGENT);
        if (StringUtils.isEmpty(agent) || !agent.contains("WebKit")) {
            response.sendError(403, " illegal agent ");
        }
        return "welcome " + name;
    }

    @ResponseBody
    @RequestMapping(path = "post2", method = {RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST},
            produces = "charset/utf8")
    public String post(HttpServletRequest request, HttpServletResponse response,
                       @RequestParam(value = "email", required = false) String email,
                       @RequestParam(value = "nick", required = false) String nick) throws IOException {
        String agent = request.getHeader(HttpHeaders.USER_AGENT);
        if (StringUtils.isEmpty(agent) || !agent.contains("WebKit")) {
            response.sendError(403, " illegal agent ");
            return null;
        }
        return "success email=" + email + "&nick=" + URLEncoder.encode(nick, "UTF-8") + "&status=success";
    }
}
