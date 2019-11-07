package ssm.controller.springresttemplate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class SpringRestTemplateFile {
    @ResponseBody
    @PostMapping(path = "file")
    public String file(MultipartHttpServletRequest request) throws IOException {
        String result = "no file!";
        MultipartFile file = request.getFile("file");
        if (file != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                builder.append(line);
                line = reader.readLine();
            }
            reader.close();
            result = builder.toString();
        }

        return result;
    }
}
