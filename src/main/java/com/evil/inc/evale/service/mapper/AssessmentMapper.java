package com.evil.inc.evale.service.mapper;

import com.evil.inc.evale.domain.Assessment;
import com.evil.inc.evale.service.dto.AssessmentSummaryDto;
import org.aspectj.lang.annotation.After;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AssessmentMapper {
    @Mappings({
            @Mapping(source = "assessment.assessedUser.username", target = "assessedUserName")
    })
    AssessmentSummaryDto toAssessmentSummaryDto(Assessment assessment);

    @AfterMapping
    default void afterMapping(@MappingTarget AssessmentSummaryDto summaryDto, Assessment assessment){
        summaryDto.setId(assessment.getId());
    }
}
