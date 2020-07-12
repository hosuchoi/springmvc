package lake.pool.webmvc.sample.httpmessageconverter;

import lake.pool.webmvc.sample.formatter.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XmlMessageConverter {

    @GetMapping("/xmlMessage")
    public Person xmlMessage(@RequestBody Person person){
        return person;
    }
}
