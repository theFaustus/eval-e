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

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@ServiceQualifier(type = Type.FAKE)
class FakeAssessmentServiceImpl implements AssessmentService {

    @Override
    public void create(final Assessment assessment) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Assessment getById(final Long id) {
        return null;
    }

    @Override
    public List<AssessmentSummaryDto> getAll() {
        return null;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("FakeAssessmentServiceImpl.postConstruct");
    }
}
