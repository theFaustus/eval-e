package com.evil.inc.evale;

import com.evil.inc.evale.repository.AssessmentRepository;
import com.evil.inc.evale.service.AssessmentService;
import com.evil.inc.evale.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Slf4j
@EnableConfigurationProperties
public class EvalEApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvalEApplication.class, args);
    }

    @Bean
    @Transactional
    public CommandLineRunner commandLineRunner(AssessmentService assessmentService, UserService userService, AssessmentRepository assessmentRepository) {
        return args -> {
//            final Assessment templateAssessment = new Assessment("3.b Service Software Engineer Medior",
//                                                                 "Medior grade evaluation form",
//                                                                 JobPosition.SENIOR,
//                                                                 null,
//                                                                 true, null, null);
//
//            final EvaluationGroup coreTasks = new EvaluationGroup("Core tasks", "Lorem ipsum");
//            coreTasks.addEvaluationField(new EvaluationField("Acquiring and managing knowledge", "Gain knowledge of the IPC system, technologies we use, business logic, procedures."));
//            final EvaluationGroup skills = new EvaluationGroup("Skills", "Lorem Ipsum");
//            skills.addEvaluationField(new EvaluationField("Organize/planning/prioritize", "Effectively set goals and priorities, determine actions to reach those goals."));
//
//            templateAssessment.addEvaluationGroup(coreTasks);
//            templateAssessment.addEvaluationGroup(skills);
//
//            assessmentService.create(templateAssessment);
//            log.info("Template assessment created {}", templateAssessment);


        };
    }

}
