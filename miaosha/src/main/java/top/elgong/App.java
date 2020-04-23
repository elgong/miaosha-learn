package top.elgong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */


@SpringBootApplication()
@RestController
public class App {

//    @RequestMapping("/")
//    public String test(){
//
//        return "test222 !";
//    }
    public static void main( String[] args ) {

        // 启动springboot
        SpringApplication.run(App.class, args);
    }
}
