package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.AgreeSet;

public interface AgreeSetRepository extends JpaRepository<AgreeSet, Long> {
    void deleteAllByMemberId(Long memberId);
}
