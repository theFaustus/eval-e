package com.evil.inc.evale.service;

import com.evil.inc.evale.config.annotations.ServiceQualifier;
import com.evil.inc.evale.config.annotations.Type;
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
@ServiceQualifier(type = Type.REAL)
class AssessmentServiceImpl implements AssessmentService {
    private final AssessmentRepository assessmentRepository;
    private final AssessmentMapper assessmentMapper;

    @Transactional
    @Override
    public void create(Assessment assessment) {
        assessment.getEvaluationGroupList().forEach(g -> g.setAssessment(assessment));
        assessment.getEvaluationGroupList().forEach(g -> g.getEvaluationFields().forEach(f -> f.setEvaluationGroup(g)));
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
        final List<Assessment> assessments = assessmentRepository.findAll();
        return assessments.stream().map(assessmentMapper::toAssessmentSummaryDto).collect(Collectors.toList());
    }
}
