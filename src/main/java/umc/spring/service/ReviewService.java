package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;
import umc.spring.repository.ReviewImgRepository;
import umc.spring.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewImgRepository reviewImgRepository;

    private final AnswerService answerService;

    @Transactional
    public void deleteReviewByMember(Long memberId) {

        List<Review> reviewList = reviewRepository.findAllByMemberId(memberId)
                .orElse(new ArrayList<>());

        for (Review review : reviewList) {

            answerService.deleteAnswerByReview(review.getId());
            reviewImgRepository.deleteAllByReviewId(review.getId());
        }

        reviewRepository.deleteAll(reviewList);
    }
}
