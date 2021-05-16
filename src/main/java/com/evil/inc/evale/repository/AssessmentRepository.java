package com.evil.inc.evale.repository;

import com.evil.inc.evale.domain.Assessment;
import com.evil.inc.evale.web.rest.projection.ShortAssessmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(excerptProjection = ShortAssessmentProjection.class)
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}
