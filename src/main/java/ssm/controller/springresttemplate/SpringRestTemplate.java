package ssm.controller.springresttemplate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SpringRestTemplate {
    @ResponseBody
    @RequestMapping(path = "success")
    public String loginSuccess(String email, String nick) {
        return "welcome " + nick;
    }

    @RequestMapping(path = "post", method = {RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST})
    public String post(HttpServletRequest request, @RequestParam(value = "email", required = false) String email,
                       @RequestParam(value = "nick", required = false) String nick) {
        return "redirect:/success?email=" + email + "&nick=" + nick + "&status=success";
    }

}
