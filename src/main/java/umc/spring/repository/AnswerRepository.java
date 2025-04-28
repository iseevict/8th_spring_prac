package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    void deleteAllByReviewId(Long reviewId);
}
