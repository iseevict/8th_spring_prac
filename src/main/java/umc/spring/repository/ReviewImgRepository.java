package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.ReviewImg;

public interface ReviewImgRepository extends JpaRepository<ReviewImg, Long> {
    void deleteAllByReviewId(Long reviewId);
}
