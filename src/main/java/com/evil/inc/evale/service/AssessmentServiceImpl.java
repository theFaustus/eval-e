package com.evil.inc.evale.service;

import com.evil.inc.evale.domain.Assessment;
import com.evil.inc.evale.repository.AssessmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {
    private final AssessmentRepository assessmentRepository;

    public void create(Assessment assessment){
        assessmentRepository.save(assessment);
    }
}
