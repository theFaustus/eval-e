package com.evil.inc.evale.service;

import com.evil.inc.evale.domain.Assessment;
import com.evil.inc.evale.domain.exception.AssessmentNotFoundException;
import com.evil.inc.evale.repository.AssessmentRepository;
import com.evil.inc.evale.service.dto.AssessmentSummaryDto;
import com.evil.inc.evale.service.mapper.AssessmentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
class AssessmentServiceImpl implements AssessmentService {
    private final AssessmentRepository assessmentRepository;
    private final AssessmentMapper assessmentMapper;

    @Transactional
    @Override
    public void create(Assessment assessment) {
        assessmentRepository.save(assessment);
    }

    @Transactional
    @Override
    public Assessment getById(Long id) {
        final Assessment assessment = assessmentRepository.findById(id).orElseThrow(
                () -> new AssessmentNotFoundException(String.format("Assessment with id [%s] not found", id)));
        log.info("Found assessment {}", assessment);
        return assessment;
    }

    @Transactional
    @Override
    public List<AssessmentSummaryDto> getAll() {
        return assessmentRepository.findAll().stream().map(assessmentMapper::toAssessmentSummaryDto).collect(Collectors.toList());
    }
}
