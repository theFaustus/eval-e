package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "ASSESSMENTS")
public class Assessment extends AbstractEntity {
    @Column(length = 1000)
    private String title;
    @Lob
    private String description;
    @Enumerated(EnumType.STRING)
    private JobPosition jobPosition;
    @Enumerated(EnumType.STRING)
    private AssessmentStatus assessmentStatus = AssessmentStatus.FIRST_PHASE;
    private Long overallScore;
    private boolean isTemplate = true;

    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User assessedUser;

    @OneToMany(mappedBy = "assessment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EvaluationGroup> evaluationGroupList = new ArrayList<>();
    @OneToMany(mappedBy = "assessment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SMARTPersonalGoal> personalGoals = new ArrayList<>();
    @OneToMany(mappedBy = "assessment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SMARTDepartmentGoal> departmentGoals = new ArrayList<>();
    @OneToMany(mappedBy = "assessment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbackList = new ArrayList<>();

    public Assessment(String title, String description, JobPosition jobPosition,
                      AssessmentStatus assessmentStatus, boolean isTemplate, LocalDate startDate,
                      LocalDate endDate) {
        this.title = title;
        this.description = description;
        this.jobPosition = jobPosition;
        this.assessmentStatus = assessmentStatus;
        this.isTemplate = isTemplate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Assessment from(Assessment template) {
        Assessment assessment = new Assessment();
        assessment.setTitle(template.getTitle());
        assessment.setDescription(template.getDescription());
        template.getEvaluationGroupList().forEach(templateEvaluationGroup -> {
            final EvaluationGroup eg = new EvaluationGroup(templateEvaluationGroup.getTitle(),
                                                           templateEvaluationGroup.getDescription());
            templateEvaluationGroup.getEvaluationFields()
                    .stream()
                    .map(templateEvaluationField -> new EvaluationField(templateEvaluationField.getName(),
                                                                        templateEvaluationField.getDescription()))
                    .forEach(eg::addEvaluationField);
            assessment.addEvaluationGroup(eg);
        });
        assessment.setJobPosition(template.getJobPosition());
        assessment.setTemplate(false);
        return assessment;
    }

    public void addEvaluationGroup(EvaluationGroup evaluationGroup) {
        evaluationGroupList.add(evaluationGroup);
        evaluationGroup.setAssessment(this);
    }

    public void addPersonalGoal(SMARTPersonalGoal goal) {
        personalGoals.add(goal);
        goal.setAssessment(this);
    }

    public void addDepartmentGoal(SMARTDepartmentGoal goal) {
        departmentGoals.add(goal);
        goal.setAssessment(this);
    }

    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
        feedback.setAssessment(this);
    }

    public void removeEvaluationGroup(EvaluationGroup evaluationGroup) {
        evaluationGroupList.remove(evaluationGroup);
        evaluationGroup.setAssessment(null);
    }

    public void removePersonalGoal(SMARTPersonalGoal goal) {
        personalGoals.remove(goal);
        goal.setAssessment(null);
    }

    public void removeDepartmentGoal(SMARTDepartmentGoal goal) {
        departmentGoals.remove(goal);
        goal.setAssessment(null);
    }

    public void removeFeedback(Feedback feedback) {
        feedbackList.remove(feedback);
        feedback.setAssessment(null);
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", grade=" + jobPosition +
                ", assessmentStatus=" + assessmentStatus +
                ", overallScore=" + overallScore +
                ", isTemplate=" + isTemplate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", assessedUser=" + (assessedUser != null ? assessedUser.getUsername() : "n/a") +
                ", evaluationGroupList=" + evaluationGroupList +
                ", personalGoals=" + personalGoals +
                ", departmentGoals=" + departmentGoals +
                ", feedbackList=" + feedbackList +
                '}';
    }
}
