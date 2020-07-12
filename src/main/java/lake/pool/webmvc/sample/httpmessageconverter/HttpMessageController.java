package lake.pool.webmvc.sample.httpmessageconverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpMessageController {

    @GetMapping("/converterMessage")
    public String message(@RequestBody String body){
        return body;
    }
}
