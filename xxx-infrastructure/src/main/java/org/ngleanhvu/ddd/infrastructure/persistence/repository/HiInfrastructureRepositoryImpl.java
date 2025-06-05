package org.ngleanhvu.ddd.infrastructure.persistence.repository;

import org.ngleanhvu.ddd.domain.repository.HiDomainRepository;
import org.springframework.stereotype.Service;

@Service
public class HiInfrastructureRepositoryImpl implements HiDomainRepository {
    @Override
    public String sayHi(String who) {
        return "Hi " + who;
    }
}
