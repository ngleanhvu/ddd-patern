package org.ngleanhvu.ddd.application.service.event.impl;

import org.ngleanhvu.ddd.application.service.event.EventApplicationService;
import org.ngleanhvu.ddd.domain.service.HiDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventApplicationServiceImpl implements EventApplicationService {
    @Autowired
    private HiDomainService hiDomainService;

    @Override
    public String sayHi(String who) {
        return hiDomainService.sayHi(who);
    }
}
