package lake.pool.webmvc.sample.resourcehandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourceHandlerController {

    @GetMapping("/resource")
    public String resource(){
        return "mobile/index";
    }
}
