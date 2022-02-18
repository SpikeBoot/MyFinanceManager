package org.spikeboot.myfinancemanager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String startPage(){
        return "start-page";
    }
}
