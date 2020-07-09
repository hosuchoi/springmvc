package lake.pool.webmvc.sample.formatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    /*
     일반적인 처리
     */
//    @GetMapping("/hello")
//    public String hellos(){
//        return "hello";
//    }

    /*
    PathVariable을 처리를 통한 처리
     */
//    @GetMapping("/hello/{name}")
//    public String hello(@PathVariable("name") String name){
//        return "hello " + name;
//    }

    /*
    Formatter를 통한 PathVariable 처리
     */
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") Person person){
        return "hello " + person.getName();
    }
//
//    /*
//    Formatter를 통한 RequestParam 처리
//     */
    @GetMapping("/hello")
    public String hellos(@RequestParam("name") Person person){
        return "hello " + person.getName();
    }

}
