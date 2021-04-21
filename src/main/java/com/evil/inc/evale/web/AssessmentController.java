package com.evil.inc.evale.web;

import com.evil.inc.evale.config.annotations.ServiceQualifier;
import com.evil.inc.evale.config.annotations.Type;
import com.evil.inc.evale.domain.Assessment;
import com.evil.inc.evale.domain.JobPosition;
import com.evil.inc.evale.domain.User;
import com.evil.inc.evale.service.AssessmentService;
import com.evil.inc.evale.service.UserService;
import com.evil.inc.evale.service.dto.AssessmentSummaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/assessments")
public class AssessmentController {

    private final AssessmentService assessmentService;

    public AssessmentController(@ServiceQualifier(type = Type.REAL) final AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    @GetMapping
    public ModelAndView viewAllAssessments(){
        final List<AssessmentSummaryDto> all = assessmentService.getAll();
        final ModelAndView modelAndView = new ModelAndView("assessments");
        modelAndView.addObject("assessments", all);
        return modelAndView;
    }


    @GetMapping("/{assessmentId}")
    public ModelAndView viewAssessment(@PathVariable Long assessmentId){
        final Assessment assessment = assessmentService.getById(assessmentId);
        final ModelAndView modelAndView = new ModelAndView("view-assessment");
        modelAndView.addObject("assessment", assessment);
        modelAndView.addObject("jobPositions", JobPosition.values());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView viewCreateAssessment(){
        final List<AssessmentSummaryDto> all = assessmentService.getAll();
        final ModelAndView modelAndView = new ModelAndView("create-assessment");
        modelAndView.addObject("jobPositions", JobPosition.values());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createAssessment(@RequestBody Assessment assessment){
        assessmentService.create(assessment);
        return new ModelAndView("redirect:/assessments");
    }

    @GetMapping("/edit/{assessmentId}")
    public ModelAndView viewEditAssessment(@PathVariable Long assessmentId){
        final Assessment assessment = assessmentService.getById(assessmentId);
        final ModelAndView modelAndView = new ModelAndView("edit-assessment");
        modelAndView.addObject("assessment", assessment);
        modelAndView.addObject("jobPositions", JobPosition.values());
        return modelAndView;
    }
}
