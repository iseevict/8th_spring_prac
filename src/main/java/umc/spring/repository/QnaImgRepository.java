package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.QnaImg;

public interface QnaImgRepository extends JpaRepository<QnaImg, Long> {
    void deleteAllByQnaId(Long qnaId);
}
