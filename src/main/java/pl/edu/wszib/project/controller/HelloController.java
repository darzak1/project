package pl.edu.wszib.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //przekazuje dane za pomocą http

public class HelloController {

    @GetMapping("/hello")// po slashu jest koncówka adresu strny gdzie to ma być wyświetlone np tu: http://localhost:8080/hello
    public String helloPage() {
        return "Hello!!!";
    }

    @GetMapping ("/powitanie")
    public String stronaPowitalna() {

        return "To jest strona powitalna  " + HelloController.class.getCanonicalName();

    }

}
