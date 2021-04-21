package com.evil.inc.evale;

import com.evil.inc.evale.config.annotations.Development;
import com.evil.inc.evale.config.annotations.ServiceQualifier;
import com.evil.inc.evale.config.annotations.Type;
import com.evil.inc.evale.domain.Assessment;
import com.evil.inc.evale.domain.EvaluationField;
import com.evil.inc.evale.domain.EvaluationGroup;
import com.evil.inc.evale.domain.JobPosition;
import com.evil.inc.evale.repository.AssessmentRepository;
import com.evil.inc.evale.service.AssessmentService;
import com.evil.inc.evale.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
@EnableConfigurationProperties
@EnableAspectJAutoProxy
public class EvalEApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvalEApplication.class, args);
    }

    @Bean
    @Development
    @Transactional
    public CommandLineRunner commandLineRunner(Environment environment, @ServiceQualifier(type = Type.REAL) AssessmentService assessmentService, UserService userService, AssessmentRepository assessmentRepository) {
        return args -> {
            log.info("Active profiles : {} ", Arrays.toString(environment.getActiveProfiles()));
            log.info("Creating assessment");
            final Assessment templateAssessment = new Assessment("3.b Service Software Engineer Medior",
                                                                 "Medior grade evaluation form",
                                                                 JobPosition.SENIOR,
                                                                 null,
                                                                 true, null, null);

            final EvaluationGroup coreTasks = new EvaluationGroup("Core tasks", "Lorem ipsum");
            coreTasks.addEvaluationField(new EvaluationField("Acquiring and managing knowledge", "Gain knowledge of the IPC system, technologies we use, business logic, procedures."));
            final EvaluationGroup skills = new EvaluationGroup("Skills", "Lorem Ipsum");
            skills.addEvaluationField(new EvaluationField("Organize/planning/prioritize", "Effectively set goals and priorities, determine actions to reach those goals."));

            templateAssessment.addEvaluationGroup(coreTasks);
            templateAssessment.addEvaluationGroup(skills);

            assessmentService.create(templateAssessment);
            log.info("Template assessment created {}", templateAssessment);

        };
    }

    @Bean
    @Transactional
    public CommandLineRunner commandLineRunner(Environment environment) {
        return args -> {
            log.info("Active profiles : {} ", Arrays.toString(environment.getActiveProfiles()));
        };
    }

}
