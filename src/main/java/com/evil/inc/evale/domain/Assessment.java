package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Assessment extends AbstractEntity {
    private String title;
    private String description;
    private Grade grade;
    private Status status = Status.FIRST_PHASE;

    private List<EvaluationGroup> evaluationGroupList = new ArrayList<>();

    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate;

    private List<SMARTGoal> personalGoals = new ArrayList<>();
    private List<SMARTGoal> departmentGoals = new ArrayList<>();

    private Long overallScore;
    private boolean isTemplate;

    private List<Feedback> feedbackList = new ArrayList<>();
}
