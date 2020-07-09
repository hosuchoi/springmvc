package lake.pool.webmvc.sample.domainconverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoseController {

    /*
    JPA 적용시 자동 적용 되는..... domain class convertor 작동 안함 ㅠㅠ
     */
    @GetMapping("/rose")
    public String rose(@RequestParam("id") Rose rose){
        System.out.println("test");
        return "hello " + rose.getName();
    }

    @GetMapping("/rose/{id}")
    public String lake(@PathVariable("id") Rose rose){
        System.out.println("test");
        return "hello " + rose.getName();
    }
}
