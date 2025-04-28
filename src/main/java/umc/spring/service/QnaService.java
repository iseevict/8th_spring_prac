package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Qna;
import umc.spring.repository.QnaImgRepository;
import umc.spring.repository.QnaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QnaService {

    private final QnaImgRepository qnaImgRepository;
    private final QnaRepository qnaRepository;

    @Transactional
    public void deleteQnaByMember(Long memberId) {
        List<Qna> qnaList = qnaRepository.findAllByMemberId(memberId)
                .orElse(new ArrayList<>());

        for (Qna qna : qnaList) {
            qnaImgRepository.deleteAllByQnaId(qna.getId());
        }

        qnaRepository.deleteAll(qnaList);
    }
}
