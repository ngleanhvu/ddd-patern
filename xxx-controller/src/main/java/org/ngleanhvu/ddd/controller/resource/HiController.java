package org.ngleanhvu.ddd.controller.resource;

import org.ngleanhvu.ddd.application.service.event.EventApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HiController {

    @Autowired
    private EventApplicationService eventApplicationService;

    @GetMapping("/hi")
    public String hi() {
        return eventApplicationService.sayHi("Vu"); 
    }
}