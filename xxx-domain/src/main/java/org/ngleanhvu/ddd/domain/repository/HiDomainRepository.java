package org.ngleanhvu.ddd.domain.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;


public interface HiDomainRepository {
    String sayHi(String who);
}
