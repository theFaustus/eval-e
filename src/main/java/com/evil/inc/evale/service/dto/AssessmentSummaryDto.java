package com.evil.inc.evale.service.dto;

import com.evil.inc.evale.domain.AssessmentStatus;
import com.evil.inc.evale.domain.JobPosition;
import com.evil.inc.evale.domain.User;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
public class AssessmentSummaryDto {
    private long id;
    private String title;
    private String description;
    private JobPosition jobPosition;
    private AssessmentStatus assessmentStatus;
    private Long overallScore;
    private boolean isTemplate;

    private LocalDate startDate;
    private LocalDate endDate;

    private String assessedUserName;
}
