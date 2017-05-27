package pl.wks.hackathon.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Marek Paczóski on 27.05.2017.
 */
@RequestMapping(value = "/tst")
@Controller
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getHelloPage(){
        return ResponseEntity.ok("hello");
    }

}
