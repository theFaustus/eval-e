package com.evil.inc.evale.service;

import com.evil.inc.evale.domain.Assessment;
import com.evil.inc.evale.domain.exception.AssessmentNotFoundException;
import com.evil.inc.evale.repository.AssessmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
class AssessmentServiceImpl implements AssessmentService {
    private final AssessmentRepository assessmentRepository;

    @Transactional
    public void create(Assessment assessment) {
        assessmentRepository.save(assessment);
    }

    @Transactional
    public Assessment getById(Long id) {
        final Assessment assessment = assessmentRepository.findById(id).orElseThrow(
                () -> new AssessmentNotFoundException(String.format("Assessment with id [%s] not found", id)));
        log.info("Found assessment {}", assessment);
        return assessment;
    }
}
