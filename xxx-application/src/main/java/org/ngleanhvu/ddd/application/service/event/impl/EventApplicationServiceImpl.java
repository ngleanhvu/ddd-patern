package org.ngleanhvu.ddd.application.service.event.impl;

import org.ngleanhvu.ddd.application.service.event.EventApplicationService;
import org.springframework.stereotype.Service;

@Service
public class EventApplicationServiceImpl implements EventApplicationService {
    @Override
    public String sayHi(String who) {
        return "Hi " + who;
    }
}
