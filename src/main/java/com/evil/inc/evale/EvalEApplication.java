package com.evil.inc.evale;

import com.evil.inc.evale.domain.Assessment;
import com.evil.inc.evale.domain.AssessmentStatus;
import com.evil.inc.evale.domain.EvaluationField;
import com.evil.inc.evale.domain.EvaluationGroup;
import com.evil.inc.evale.domain.Feedback;
import com.evil.inc.evale.domain.FeedbackAnswer;
import com.evil.inc.evale.domain.FeedbackQuestion;
import com.evil.inc.evale.domain.JobPosition;
import com.evil.inc.evale.domain.SMARTDepartmentGoal;
import com.evil.inc.evale.domain.SMARTPersonalGoal;
import com.evil.inc.evale.domain.User;
import com.evil.inc.evale.repository.AssessmentRepository;
import com.evil.inc.evale.repository.UserRepository;
import com.evil.inc.evale.service.AssessmentService;
import com.evil.inc.evale.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Slf4j
public class EvalEApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvalEApplication.class, args);
    }

    @Bean
    @Transactional
    public CommandLineRunner commandLineRunner(AssessmentService assessmentService, UserService userService) {
        return args -> {

            final User user = new User("bob", "dylan", "bdylan", "123", "bdylan@gmail.com", JobPosition.SENIOR);
            final User user1 = new User("bobbie", "dylan", "bdylan", "123", "bdylan@gmail.com", JobPosition.SENIOR);

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

            final Assessment assessment = Assessment.from(templateAssessment);
            assessment.setAssessmentStatus(AssessmentStatus.FIRST_PHASE);
            assessment.addPersonalGoal(new SMARTPersonalGoal("Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum"));
            assessment.addDepartmentGoal(new SMARTDepartmentGoal("Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum"));

            final Feedback feedback = new Feedback(false, "Good guy", user1);
            feedback.addQuestion(new FeedbackQuestion("Lorem Ipsum", FeedbackAnswer.NO));

            assessment.addFeedback(feedback);

            log.info("Assessment created {}", assessment);

            user.addAssessment(assessment);
//            userRepository.save(user1);
            assessmentService.create(assessment);
            userService.create(user);

        };
    }

}
