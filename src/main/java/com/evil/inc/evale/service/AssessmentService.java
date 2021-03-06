package com.evil.inc.evale.service;

import com.evil.inc.evale.domain.Assessment;
import com.evil.inc.evale.service.dto.AssessmentSummaryDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AssessmentService {
    void create(Assessment assessment);
    Assessment getById(Long id);
    List<AssessmentSummaryDto> getAll();
}
