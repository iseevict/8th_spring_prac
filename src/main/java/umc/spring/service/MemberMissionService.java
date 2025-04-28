package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.repository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    public void deleteMemberMissionByMember(Long memberId) {

        memberMissionRepository.deleteAllByMemberId(memberId);
    }
}
