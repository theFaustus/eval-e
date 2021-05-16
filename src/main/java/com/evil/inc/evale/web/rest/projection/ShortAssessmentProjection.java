package com.evil.inc.evale.web.rest.projection;

import com.evil.inc.evale.domain.Assessment;
import com.evil.inc.evale.domain.AssessmentStatus;
import com.evil.inc.evale.domain.Feedback;
import com.evil.inc.evale.domain.JobPosition;
import com.evil.inc.evale.domain.SMARTDepartmentGoal;
import com.evil.inc.evale.domain.SMARTPersonalGoal;
import com.evil.inc.evale.domain.User;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;
import java.util.List;

@Projection(name = "shortAssessmentProjection", types = {Assessment.class})
public interface ShortAssessmentProjection {
    String getTitle();

    String getDescription();

    JobPosition getJobPosition();

    AssessmentStatus getAssessmentStatus();

    Long getOverallScore();

    boolean isTemplate();

    LocalDate getStartDate();

    LocalDate getEndDate();

    User getAssessedUser();

}
